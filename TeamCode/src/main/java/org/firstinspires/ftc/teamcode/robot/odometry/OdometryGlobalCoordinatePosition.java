package org.firstinspires.ftc.teamcode.robot.odometry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ReadWriteFile;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;
import java.io.File;

public class OdometryGlobalCoordinatePosition implements Runnable {
    private DcMotor verticalLeftEncoder;
    private DcMotor verticalRightEncoder;
    private DcMotor horizontalEncoder;

    /**
     * The thread's current condition.
     */
    private boolean isRunning;

    double verticalLeftEncoderWheelPosition;
    double verticalRightEncoderWheelPosition;
    double normalEncoderWheelPosition;
    double changeInOrientation;

    private double globalXCoordinatePosition;
    public double xCoordinate() {
        return globalXCoordinatePosition;
    }
    private double globalYCoordinatePosition;
    public double yCoordinate() {
        return globalYCoordinatePosition;
    }

    /**
     * The orientation (in radians).
     */
    private double orientationRadians;
    public double orientationRadians() {
        return orientationRadians;
    }
    public double orientationDegrees() {
        return Math.toDegrees(orientationRadians) % 360;
    }

    private double previousVerticalLeftEncoderWheelPosition;
    private double previousVerticalRightEncoderWheelPosition;
    private double previousNormalEncoderWheelPosition;

    private double encoderWheelDistance;
    private double horizontalEncoderTickPerDegreeOffset;

    /**
     * Sleep interval (in milliseconds) for the position update thread.
     */
    private int sleepInterval;

    private int verticalLeftEncoderPositionMultiplier = 1;
    private int verticalRightEncoderPositionMultiplier = 1;
    private int normalEncoderPositionMultiplier = 1;

    public OdometryGlobalCoordinatePosition(DcMotor verticalLeftEncoder, DcMotor verticalRightEncoder, DcMotor horizontalEncoder, int sleepInterval, double wheelBaseSeparation, double ticksPerInch, double horizontalTickOffset) {
        this.verticalLeftEncoder = verticalLeftEncoder;
        this.verticalRightEncoder = verticalRightEncoder;
        this.horizontalEncoder = horizontalEncoder;
        this.sleepInterval = sleepInterval;

        this.encoderWheelDistance = wheelBaseSeparation * ticksPerInch;
        this.horizontalEncoderTickPerDegreeOffset = horizontalTickOffset;
    }

    private void update() {
        verticalLeftEncoderWheelPosition = verticalLeftEncoder.getCurrentPosition() * verticalLeftEncoderPositionMultiplier;
        verticalRightEncoderWheelPosition = verticalRightEncoder.getCurrentPosition() * verticalRightEncoderPositionMultiplier;

        double leftChange = verticalLeftEncoderWheelPosition - previousVerticalLeftEncoderWheelPosition;
        double rightChange = verticalRightEncoderWheelPosition - previousVerticalRightEncoderWheelPosition;

        changeInOrientation = (leftChange - rightChange) / encoderWheelDistance;
        orientationRadians = orientationRadians + changeInOrientation;

        normalEncoderWheelPosition = horizontalEncoder.getCurrentPosition() * normalEncoderPositionMultiplier;

        double rawHorizontalChange = normalEncoderWheelPosition - previousNormalEncoderWheelPosition;
        double horizontalChange = rawHorizontalChange - (changeInOrientation * horizontalEncoderTickPerDegreeOffset);

        double p = (leftChange + rightChange) / 2;
        double n = horizontalChange;

        globalXCoordinatePosition += (p * Math.sin(orientationRadians)) + (n * Math.cos(orientationRadians));
        globalYCoordinatePosition += (p * Math.cos(orientationRadians)) - (n * Math.sin(orientationRadians));

        previousVerticalLeftEncoderWheelPosition = verticalLeftEncoderWheelPosition;
        previousVerticalRightEncoderWheelPosition = verticalRightEncoderWheelPosition;
        previousNormalEncoderWheelPosition = normalEncoderWheelPosition;
    }

    public void stop() {
        isRunning = false;
    }

    public void reverseVerticalLeftEncoder() {
        if (verticalLeftEncoderPositionMultiplier == 1) {
            verticalLeftEncoderPositionMultiplier = -1;
        } else if (verticalLeftEncoderPositionMultiplier == -1) {
            verticalLeftEncoderPositionMultiplier = 1;
        }
    }

    public void reverseVerticalRightEncoder() {
        if (verticalRightEncoderPositionMultiplier == 1) {
            verticalRightEncoderPositionMultiplier = -1;
        } else if (verticalRightEncoderPositionMultiplier == -1) {
            verticalRightEncoderPositionMultiplier = 1;
        }
    }

    public void reverseNormalEncoder() {
        if (normalEncoderPositionMultiplier == 1) {
            normalEncoderPositionMultiplier = -1;
        } else if (normalEncoderPositionMultiplier == -1) {
            normalEncoderPositionMultiplier = 1;
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            update();
            try {
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
