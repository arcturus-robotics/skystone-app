package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Odometry implements Runnable {
    private boolean running;

    public DcMotor verticalLeft;
    public double verticalLeftPosition;
    public double previousVerticalLeftPosition;
    public double verticalLeftPositionMultiplier;

    public DcMotor verticalRight;
    public double verticalRightPosition;
    public double previousVerticalRightPosition;
    public double verticalRightPositionMultiplier;

    public DcMotor horizontal;
    public double horizontalPosition;
    public double previousHorizontalPosition;
    public double horizontalPositionMultiplier;

    public double x;
    public double y;
    public double orientation;

    public double verticalDistance;
    public double horizontalTickPerDegreeOffset;

    public long interval;

    public Odometry(DcMotor verticalLeft, DcMotor verticalRight, DcMotor horizontal) {
        this.verticalLeft = verticalLeft;
        this.verticalRight = verticalRight;
        this.horizontal = horizontal;
    }

    public void reverseVerticalLeftEncoderWheel() {
        if (verticalLeftPositionMultiplier == 1) {
            verticalLeftPositionMultiplier = -1;
        } else if (verticalLeftPositionMultiplier == -1) {
            verticalLeftPositionMultiplier = 1;
        }
    }

    public void reverseVerticalRightEncoderWheel() {
        if (verticalRightPositionMultiplier == 1) {
            verticalRightPositionMultiplier = -1;
        } else if (verticalRightPositionMultiplier == -1) {
            verticalRightPositionMultiplier = 1;
        }
    }

    public void reverseHorizontalEncoderWheel() {
        if (horizontalPositionMultiplier == 1) {
            horizontalPositionMultiplier = -1;
        } else if (horizontalPositionMultiplier == -1) {
            horizontalPositionMultiplier = 1;
        }
    }

    public void start() { running = true; }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            update();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        verticalLeftPosition = verticalLeft.getCurrentPosition() * verticalLeftPositionMultiplier;
        verticalRightPosition = verticalRight.getCurrentPosition() * verticalRightPositionMultiplier;

        double leftChange = verticalLeftPosition - previousVerticalLeftPosition;
        double rightChange = verticalRightPosition - previousVerticalRightPosition;

        double orientationUpdate = (leftChange - rightChange) / verticalDistance;
        orientation += orientationUpdate;

        horizontalPosition = horizontal.getCurrentPosition() * horizontalPositionMultiplier;

        double rawHorizontalUpdate = horizontalPosition - previousHorizontalPosition;
        double horizontalUpdate = rawHorizontalUpdate - (orientationUpdate * horizontalTickPerDegreeOffset);

        double p = (leftChange + rightChange) / 2.0;

        x += (p * Math.sin(orientation)) + (horizontalUpdate * Math.cos(orientation));
        y += (p * Math.cos(orientation)) - (horizontalUpdate * Math.sin(orientation));

        previousVerticalLeftPosition = verticalLeftPosition;
        previousVerticalRightPosition = verticalRightPosition;
        previousHorizontalPosition = horizontalPosition;
    }
}
