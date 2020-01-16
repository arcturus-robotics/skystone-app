package org.firstinspires.ftc.teamcode.robot.odometry;

import com.qualcomm.robotcore.hardware.DcMotor;

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

    private double x;
    private double y;
    /**
     * The orientation (in radians).
     */
    private double orientation;
    private double orientationUpdate;

    private double previousVerticalLeftEncoderWheelPosition;
    private double previousVerticalRightEncoderWheelPosition;
    private double previousHorizontalEncoderWheelPosition;


    private double horizontalEncoderTickPerDegreeOffset;

    /**
     * Sleep interval (in milliseconds) for the position update thread.
     */
    private int sleepInterval;
    private double ticksPerInch;
    private double wheelBaseSeparation;
    private double encoderWheelDistance;

    private int verticalLeftEncoderWheelPositionMultiplier = 1;
    private int verticalRightEncoderWheelPositionMultiplier = 1;
    private int horizontalEncoderWheelPositionMultiplier = 1;

    public OdometryPosition(
            DcMotor verticalLeftEncoderWheel,
            DcMotor verticalRightEncoderWheel,
            DcMotor horizontalEncoderWheel,
            int sleepInterval,
            double ticksPerInch,
            double horizontalEncoderTickPerDegreeOffset,
            double wheelBaseSeparation
    ) {
        this.verticalLeftEncoderWheel = verticalLeftEncoderWheel;
        this.verticalRightEncoderWheel = verticalRightEncoderWheel;
        this.horizontalEncoderWheel = horizontalEncoderWheel;

        this.sleepInterval = sleepInterval;
        this.ticksPerInch = ticksPerInch;
        this.horizontalEncoderTickPerDegreeOffset = horizontalEncoderTickPerDegreeOffset;
        this.wheelBaseSeparation = wheelBaseSeparation;

        this.encoderWheelDistance = wheelBaseSeparation * ticksPerInch;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double orientationRadians() {
        return orientation;
    }

    public double orientationDegrees() {
        return Math.toDegrees(orientation) % 360;
    }

    private void update() {
        verticalLeftEncoderWheelPosition = verticalLeftEncoderWheel.getCurrentPosition() * verticalLeftEncoderWheelPositionMultiplier;
        verticalRightEncoderWheelPosition = verticalRightEncoderWheel.getCurrentPosition() * verticalRightEncoderWheelPositionMultiplier;

        double leftChange = verticalLeftEncoderWheelPosition - previousVerticalLeftEncoderWheelPosition;
        double rightChange = verticalRightEncoderWheelPosition - previousVerticalRightEncoderWheelPosition;

        orientationUpdate = (leftChange - rightChange) / encoderWheelDistance;
        orientation += orientationUpdate;

        horizontalEncoderWheelPosition = horizontalEncoderWheel.getCurrentPosition() * horizontalEncoderWheelPositionMultiplier;

        double rawHorizontalUpdate = horizontalEncoderWheelPosition - previousHorizontalEncoderWheelPosition;
        double horizontalUpdate = rawHorizontalUpdate - (orientationUpdate * horizontalEncoderTickPerDegreeOffset);

        double p = (leftChange + rightChange) / 2.0;

        x += (p * Math.sin(orientation)) + (horizontalUpdate * Math.cos(orientation));
        y += (p * Math.cos(orientation)) - (horizontalUpdate * Math.sin(orientation));

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
