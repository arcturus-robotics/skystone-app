package org.firstinspires.ftc.teamcode.robot.odometry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ReadWriteFile;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;
import java.io.File;

public class OdometryPosition implements Runnable {
    /**
     * The thread's current condition.
     */
    private boolean running;

    private DcMotor verticalLeftEncoderWheel;
    private double verticalLeftEncoderWheelPosition;
    private DcMotor verticalRightEncoderWheel;
    private double verticalRightEncoderWheelPosition;
    private DcMotor horizontalEncoderWheel;
    private double horizontalEncoderWheelPosition;

    private double xPosition;
    public double xPosition() { return xPosition; }
    private double yPosition;
    public double yPosition() { return yPosition; }

    /**
     * The orientation (in radians).
     */
    private double orientation;
    private double orientationUpdate;

    public double orientationRadians() {
        return orientation;
    }
    public double orientationDegrees() {
        return Math.toDegrees(orientation) % 360;
    }

    private double previousVerticalLeftEncoderWheelPosition;
    private double previousVerticalRightEncoderWheelPosition;
    private double previousHorizontalEncoderWheelPosition;

    private double encoderWheelDistance;
    private double horizontalEncoderTickPerDegreeOffset;

    /**
     * Sleep interval (in milliseconds) for the position update thread.
     */
    private int sleepInterval;

    private int verticalLeftEncoderWheelPositionMultiplier = 1;
    private int verticalRightEncoderWheelPositionMultiplier = 1;
    private int horizontalEncoderWheelPositionMultiplier = 1;

    public OdometryPosition(DcMotor verticalLeftEncoderWheel, DcMotor verticalRightEncoderWheel, DcMotor horizontalEncoderWheel, int sleepInterval, double wheelBaseSeparation, double ticksPerInch, double horizontalTickOffset) {
        this.verticalLeftEncoderWheel = verticalLeftEncoderWheel;
        this.verticalRightEncoderWheel = verticalRightEncoderWheel;
        this.horizontalEncoderWheel = horizontalEncoderWheel;
        this.sleepInterval = sleepInterval;

        this.encoderWheelDistance = wheelBaseSeparation * ticksPerInch;
        this.horizontalEncoderTickPerDegreeOffset = horizontalTickOffset;
    }

    private void update() {
        verticalLeftEncoderWheelPosition = verticalLeftEncoderWheel.getCurrentPosition() * verticalLeftEncoderWheelPositionMultiplier;
        verticalRightEncoderWheelPosition = verticalRightEncoderWheel.getCurrentPosition() * verticalRightEncoderWheelPositionMultiplier;

        double leftChange = verticalLeftEncoderWheelPosition - previousVerticalLeftEncoderWheelPosition;
        double rightChange = verticalRightEncoderWheelPosition - previousVerticalRightEncoderWheelPosition;

        orientationUpdate = (leftChange - rightChange) / encoderWheelDistance;
        orientation += orientationUpdate;

        horizontalEncoderWheelPosition = horizontalEncoderWheel.getCurrentPosition() * horizontalEncoderWheelPositionMultiplier;

        double rawHorizontalChange = horizontalEncoderWheelPosition - previousHorizontalEncoderWheelPosition;
        double horizontalChange = rawHorizontalChange - (orientationUpdate * horizontalEncoderTickPerDegreeOffset);

        double p = (leftChange + rightChange) / 2;
        double n = horizontalChange;

        xPosition += (p * Math.sin(orientation)) + (n * Math.cos(orientation));
        yPosition += (p * Math.cos(orientation)) - (n * Math.sin(orientation));

        previousVerticalLeftEncoderWheelPosition = verticalLeftEncoderWheelPosition;
        previousVerticalRightEncoderWheelPosition = verticalRightEncoderWheelPosition;
        previousHorizontalEncoderWheelPosition = horizontalEncoderWheelPosition;
    }

    public void stop() {
        running = false;
    }

    public void reverseVerticalLeftEncoderWheel() {
        if (verticalLeftEncoderWheelPositionMultiplier == 1) {
            verticalLeftEncoderWheelPositionMultiplier = -1;
        } else if (verticalLeftEncoderWheelPositionMultiplier == -1) {
            verticalLeftEncoderWheelPositionMultiplier = 1;
        }
    }

    public void reverseVerticalRightEncoderWheel() {
        if (verticalRightEncoderWheelPositionMultiplier == 1) {
            verticalRightEncoderWheelPositionMultiplier = -1;
        } else if (verticalRightEncoderWheelPositionMultiplier == -1) {
            verticalRightEncoderWheelPositionMultiplier = 1;
        }
    }

    public void reverseHorizontalEncoderWheel() {
        if (horizontalEncoderWheelPositionMultiplier == 1) {
            horizontalEncoderWheelPositionMultiplier = -1;
        } else if (horizontalEncoderWheelPositionMultiplier == -1) {
            horizontalEncoderWheelPositionMultiplier = 1;
        }
    }

    @Override
    public void run() {
        while (running) {
            update();
            try {
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
