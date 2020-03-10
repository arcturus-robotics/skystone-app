package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Utilities;

/**
 * A Mecanum drive component.
 */
public class Drive {
    /**
     * The front-left motor.
     */
    public DcMotor frontLeft;
    /**
     * The front-right motor.
     */
    public DcMotor frontRight;
    /**
     * The back-left motor.
     */
    public DcMotor backLeft;
    /**
     * The back-right motor.
     */
    public DcMotor backRight;

    /**
     * The minimum power of the motors.
     * Not strictly maintained.
     */
    public double minimumPower = 0.0;
    /**
     * The maximum power of the motors.
     * Not strictly maintained.
     */
    public double maximumPower = 1.0;

    /**
     * The duration of time to sleep between motor movements.
     */
    public long padding = 0;

    /**
     * Initialize a component with no specific power limits or padding duration.
     * @param frontLeft The front-left motor.
     * @param frontRight The front-right motor.
     * @param backLeft The back-left motor.
     * @param backRight The back-right motor.
     */
    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;

        initialize();
    }

    /**
     * Initialize a component with specific power limits but no padding duration.
     * @param frontLeft The front-left motor.
     * @param frontRight The front-right motor.
     * @param backLeft The back-left motor.
     * @param backRight The back-right motor.
     * @param minimumPower The motors' minimum power.
     * @param maximumPower The motors' maximum power.
     */
    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight, double minimumPower, double maximumPower) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.minimumPower = minimumPower;
        this.maximumPower = maximumPower;
    }

    /**
     * Initialize a component with a padding duration but no specific power limits.
     * @param frontLeft The front-left motor.
     * @param frontRight The front-right motor.
     * @param backLeft The back-left motor.
     * @param backRight The back-right motor.
     * @param padding The duration to sleep between each movement.
     */
    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight, long padding) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.padding = padding;

        initialize();
    }

    /**
     * Initialize a component with specific power limits and a padding duration.
     * @param frontLeft The front-left motor.
     * @param frontRight The front-right motor.
     * @param backLeft The back-left motor.
     * @param backRight The back-right motor.
     * @param minimumPower The motors' minimum power.
     * @param maximumPower The motor's maximum power.
     * @param padding The duration to sleep between each movement.
     */
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

    /**
     * Start the motors with a specific amount of power for each.
     * @param frontLeftPower The power for the front-left motor.
     * @param frontRightPower The power for the front-right motor.
     * @param backLeftPower The power for the back-left motor.
     * @param backRightPower The power for the back-right motor.
     */
    public void start(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }

    /**
     * Stop all of the motors, i.e., set each of the motor's power to 0.
     */
    public void stop() {
        frontLeft.setPower(0.0);
        frontRight.setPower(0.0);
        backLeft.setPower(0.0);
        backRight.setPower(0.0);
    }

    /**
     * Drive each of the motors for a specific duration.
     * @param frontLeftPower The power for the front-left motor.
     * @param frontRightPower The power for the front-right motor.
     * @param backLeftPower The power for the back-left motor.
     * @param backRightPower The power for the back-right motor.
     * @param duration The duration to drive for.
     */
    public void drive(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        start(frontLeftPower, frontRightPower, backLeftPower, backRightPower);

        Utilities.sleep(duration);

        stop();

        Utilities.sleep(padding);
    }

    /**
     * Drive forward.
     * @param power The power to drive with.
     * @param duration The duration to drive for.
     */
    public void forward(double power, long duration) {
        drive(
                power, power,
                power, power,
                duration
        );
    }

    /**
     * Drive forward at maximum power.
     * @param duration The duration to drive for.
     */
    public void forwardMaximum(long duration) {
        forward(maximumPower, duration);
    }

    /**
     * Drive forward at minimum power.
     * @param duration The duration to drive for.
     */
    public void forwardMinimum(long duration) {
        forward(minimumPower, duration);
    }

    /**
     * Drive backward.
     * @param power The power to drive with.
     * @param duration The duration to drive for.
     */
    public void backward(double power, long duration) {
        drive(
                -power, -power,
                -power, -power,
                duration
        );
    }

    /**
     * Drive backward at maximum power.
     * @param duration The duration to drive for.
     */
    public void backwardMaximum(long duration) {
        backward(maximumPower, duration);
    }

    /**
     * Drive backward at minimum power.
     * @param duration The duration to drive for.
     */
    public void backwardMinimum(long duration) {
        backward(minimumPower, duration);
    }

    /**
     * Drive left.
     * @param power The power to drive with.
     * @param duration The duration to drive for.
     */
    public void left(double power, long duration) {
        drive(
                -power, power,
                power, -power,
                duration
        );
    }

    /**
     * Drive left at maximum power.
     * @param duration The duration to drive for.
     */
    public void leftMaximum(long duration) {
        left(maximumPower, duration);
    }

    /**
     * Drive left at minimum power.
     * @param duration The duration to drive for.
     */
    public void leftMinimum(long duration) {
        left(minimumPower, duration);
    }

    /**
     * Drive right.
     * @param power The power to drive with.
     * @param duration The duration to drive for.
     */
    public void right(double power, long duration) {
        drive(
                power, -power,
                -power, power,
                duration
        );
    }

    /**
     * Drive right at maximum power.
     * @param duration The duration to drive for.
     */
    public void rightMaximum(long duration) {
        right(maximumPower, duration);
    }

    /**
     * Drive right at minimum power.
     * @param duration The duration to drive for.
     */
    public void rightMinimum(long duration) {
        right(minimumPower, duration);
    }

    /**
     * Turn left.
     * @param power The power to turn with.
     * @param duration The duration to turn for.
     */
    public void turnLeft(double power, long duration) {
        drive(
                -power, power,
                -power, power,
                duration
        );
    }

    /**
     * Turn left at maximum power.
     * @param duration The duration to turn for.
     */
    public void turnLeftMaximum(long duration) {
        turnLeft(maximumPower, duration);
    }

    /**
     * Turn left at minimum power.
     * @param duration The duration to turn for.
     */
    public void turnLeftMinimum(long duration) {
        turnLeft(minimumPower, duration);
    }

    /**
     * Turn right.
     * @param power The power to turn with.
     * @param duration The duration to turn for.
     */
    public void turnRight(double power, long duration) {
        drive(
                power, -power,
                power, -power,
                duration
        );
    }

    /**
     * Turn right at maximum power.
     * @param duration The duration to turn for.
     */
    public void turnRightMaximum(long duration) {
        turnRight(maximumPower, duration);
    }

    /**
     * Turn right at minimum power.
     * @param duration The duration to turn for.
     */
    public void turnRightMinimum(long duration) {
        turnRight(minimumPower, duration);
    }

    /**
     * Initialize each of the motors to its proper configuration.
     */
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
