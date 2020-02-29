package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Constants;
import com.qualcomm.robotcore.util.Range;

public class Drive {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public double minimumPower = 0.0;
    public double maximumPower = 1.0;
    public long padding = 0;

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;

        initialize();
    }

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight, double minimumPower, double maximumPower) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.minimumPower = minimumPower;
        this.maximumPower = maximumPower;
    }

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight, long padding) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.padding = padding;

        initialize();
    }

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight, double minimumPower, double maximumPower, long padding) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.minimumPower = minimumPower;
        this.maximumPower = maximumPower;
        this.padding = padding;

        initialize();
    }

    public void start(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        frontLeft.setPower(Range.clip(frontLeftPower, minimumPower, maximumPower));
        frontRight.setPower(Range.clip(frontRightPower, minimumPower, maximumPower));
        backLeft.setPower(Range.clip(backLeftPower, minimumPower, maximumPower));
        backRight.setPower(Range.clip(backRightPower, minimumPower, maximumPower));
    }

    public void stop() {
        frontLeft.setPower(0.0);
        frontRight.setPower(0.0);
        backLeft.setPower(0.0);
        backRight.setPower(0.0);
    }

    public void drive(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        start(frontLeftPower, frontRightPower, backLeftPower, backRightPower);

        sleep(duration);

        stop();

        sleep(padding);
    }

    public void forward(double power, long duration) {
        drive(
                power, power,
                power, power,
                duration
        );
    }

    public void backward(double power, long duration) {
        drive(
                -power, -power,
                -power, -power,
                duration
        );
    }

    public void left(double power, long duration) {
        drive(
                -power, power,
                power, -power,
                duration
        );
    }

    public void right(double power, long duration) {
        drive(
                power, -power,
                -power, power,
                duration
        );
    }

    public void turnLeft(double power, long duration) {
        drive(
                -power, power,
                -power, power,
                duration
        );
    }

    public void turnRight(double power, long duration) {
        drive(
                power, -power,
                power, -power,
                duration
        );
    }

    private void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void initialize() {
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(0.0);
        frontRight.setPower(0.0);
        backLeft.setPower(0.0);
        backRight.setPower(0.0);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
