package org.firstinspires.ftc.teamcode.robot;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Utilities;

/**
 * An opmode with many utility methods and constants for autonomous programs.
 */
public class RobotLinearOpMode extends LinearOpMode {
    private static final double ARM_MAX = 1.0;
    private static final double ARM_MIN = 0.125;
    /**
     * The amount of encoder ticks per inch the robot moves.
     */
    public static final double TICKS_PER_INCH = 1.0;
    /**
     * The duration of autonomous (in milliseconds).
     */
    public static final long AUTONOMOUS_DURATION = 30000;

    /**
     * The duration of the initial delay. This delay can prevent our autonomous from clashing with our ally's autonomous.
     */
    public static final long INITIAL_DELAY_DURATION = 0;

    /**
     * Padding between each movement of the motors, servos, etc. (in milliseconds).
     */
    public static final long MOVEMENT_PADDING_DURATION = 30;

    /**
     * The duration to move away from the wall.
     */
    public static final long MOVEMENT_FROM_WALL_DURATION = 200;

    /**
     * The duration to move toward the skybridge.
     */
    public static final long MOVEMENT_TO_SKYBRIDGE_DURATION = 2500;

    /**
     * The duration to move away from the wall, but for taking the scenic route.
     */
    public static final long SCENIC_MOVEMENT_FROM_WALL_DURATION = 1250;

    /**
     * The duration to move toward the skybridge, but for taking the scenic route.
     */
    public static final long SCENIC_MOVEMENT_TO_SKYBRIDGE_DURATION = 2500;

    public double drivePower = 0.5;
    protected RobotHardware robot = new RobotHardware();
    protected ElapsedTime period = new ElapsedTime();

    /**
     * Run the opmode.
     */
    @Override
    public void runOpMode() {
        // Initialize the robot using the hardware map.
        robot.init(hardwareMap);

        // Wait until the driver presses PLAY.
        waitForStart();

        // Reset the elapsed time so we can accurately measure it.
        period.reset();

        sleep(INITIAL_DELAY_DURATION);
    }

    /**
     * Power the drive motors with specific amounts of power.
     *
     * @param frontLeftPower  The power to drive the front left drive motor with.
     * @param frontRightPower The power to drive the front right drive motor with.
     * @param backLeftPower   The power to drive the back left drive motor with.
     * @param backRightPower  The power to drive the back right drive motor with.
     */
    protected void enable(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        robot.frontLeftDrive.setPower(frontLeftPower);
        robot.frontRightDrive.setPower(frontRightPower);
        robot.backLeftDrive.setPower(backLeftPower);
        robot.backRightDrive.setPower(backRightPower);
    }

    /**
     * Stop all drive motors.
     */
    protected void disable() {
        robot.frontLeftDrive.setPower(0.0);
        robot.frontRightDrive.setPower(0.0);
        robot.backLeftDrive.setPower(0.0);
        robot.backRightDrive.setPower(0.0);
    }

    /**
     * Utility function for driving.
     * Takes power for each drive motor and the duration to drive for.
     *
     * @param frontLeftPower  The power to drive the front left drive motor with.
     * @param frontRightPower The power to drive the front right drive motor with.
     * @param backLeftPower   The power to drive the back left drive motor with.
     * @param backRightPower  The power to drive the back right drive motor with.
     * @param duration        The duration to drive for (in milliseconds).
     * @see RobotHardware#frontLeftDrive
     * @see RobotHardware#frontRightDrive
     * @see RobotHardware#backLeftDrive
     * @see RobotHardware#backRightDrive
     * @see #MOVEMENT_PADDING_DURATION
     */
    protected void driveRaw(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        enable(frontLeftPower, frontRightPower, backLeftPower, backRightPower);

        sleep(duration);

        disable();

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Utility function for driving.
     * Takes power for each drive motor
     * (but multiplies it by <code>drivePower</code>)
     * and the duration to drive for.
     *
     * @param frontLeftPower  The power to drive the front left drive motor with.
     * @param frontRightPower The power to drive the front right drive motor with.
     * @param backLeftPower   The power to drive the back left drive motor with.
     * @param backRightPower  The power to drive the back right drive motor with.
     * @param duration        The duration to drive for (in milliseconds).
     * @see #driveRaw
     */
    protected void drive(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        driveRaw(
                drivePower * frontLeftPower, drivePower * frontRightPower,
                drivePower * backLeftPower, drivePower * backRightPower,
                duration
        );
    }

    /**
     * Drive forward.
     *
     * @param duration The duration to drive for.
     */
    protected void driveForward(double power, long duration) {
        drive(
                power, power,
                power, power,
                duration
        );
    }

    /**
     * Drive left.
     *
     * @param duration The duration to drive for.
     */
    protected void driveLeft(double power, long duration) {
        drive(
                -power, power,
                power, -power,
                duration
        );
    }

    /**
     * Drive backward.
     *
     * @param duration The duration to drive for.
     */
    protected void driveBackward(double power, long duration) {
        drive(
                -power, -power,
                -power, -power,
                duration
        );
    }

    /**
     * Drive right.
     *
     * @param duration The duration to drive for.
     */
    protected void driveRight(double power, long duration) {
        drive(
                power, -power,
                -power, power,
                duration
        );
    }

    /**
     * Turn left.
     *
     * @param duration The duration to drive for.
     */
    protected void turnLeft(double power, long duration) {
        drive(
                -power, power,
                -power, power,
                duration
        );
    }

    /**
     * Turn right.
     *
     * @param duration The duration to drive for.
     */
    protected void turnRight(double power, long duration) {
        drive(
                power, -power,
                power, -power,
                duration
        );
    }

    /**
     * Drive forward.
     *
     * @param duration The duration to drive for.
     */
    protected void driveForward(long duration) {
        driveForward(1.0, duration);
    }

    /**
     * Drive left.
     *
     * @param duration The duration to drive for.
     */
    protected void driveLeft(long duration) {
        driveLeft(1.0, duration);
    }

    /**
     * Drive backward.
     *
     * @param duration The duration to drive for.
     */
    protected void driveBackward(long duration) {
        driveBackward(1.0, duration);
    }

    /**
     * Drive right.
     *
     * @param duration The duration to drive for.
     */
    protected void driveRight(long duration) {
        driveRight(1.0, duration);
    }

    /**
     * Turn left.
     *
     * @param duration The duration to drive for.
     */
    protected void turnLeft(long duration) {
        turnLeft(1.0, duration);
    }

    /**
     * Turn right.
     *
     * @param duration The duration to drive for.
     */
    protected void turnRight(long duration) {
        turnRight(1.0, duration);
    }

    /**
     * Rotate the left claw servo to a specific position.
     *
     * @param degrees The angle to turn the intake to.
     */
    protected void rotateLeftClaw(double degrees) {
        if (degrees > 0) {
            robot.leftClaw.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.leftClaw.setDirection(Servo.Direction.REVERSE);
        }

        robot.leftClaw.setPosition(Utilities.degreesToGoBildaServoPosition(degrees));

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Turn the left claw servo relative to its current position.
     *
     * @param degrees The angle to turn the intake for.
     */
    protected void turnLeftClaw(double degrees) {
        double position = Utilities.degreesToGoBildaServoPosition(degrees);
        double lastPosition = robot.leftClaw.getPosition();
        if (robot.leftClaw.getDirection() == Servo.Direction.REVERSE) {
            lastPosition = -lastPosition;
        }

        double delta = lastPosition + position;

        if (delta > 0.0) {
            robot.leftClaw.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.leftClaw.setDirection(Servo.Direction.REVERSE);
        }

        robot.leftClaw.setPosition(Utilities.degreesToGoBildaServoPosition(delta));

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Rotate the right claw servo to a specific position.
     *
     * @param degrees The angle to turn the intake to.
     */
    protected void rotateRightClaw(double degrees) {
        if (degrees > 0) {
            robot.rightClaw.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.rightClaw.setDirection(Servo.Direction.REVERSE);
        }

        robot.rightClaw.setPosition(Utilities.degreesToGoBildaServoPosition(degrees));

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Turn the right claw servo relative to its current position.
     *
     * @param degrees The angle to turn the intake for.
     */
    protected void turnRightClaw(double degrees) {
        double position = Utilities.degreesToGoBildaServoPosition(degrees);
        double lastPosition = robot.rightClaw.getPosition();
        if (robot.rightClaw.getDirection() == Servo.Direction.REVERSE) {
            lastPosition = -lastPosition;
        }

        double delta = lastPosition + position;

        if (delta > 0.0) {
            robot.rightClaw.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.rightClaw.setDirection(Servo.Direction.REVERSE);
        }

        robot.rightClaw.setPosition(Utilities.degreesToGoBildaServoPosition(delta));

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Rotate the claw servo to a specific position.
     *
     * @param degrees The angle to turn the intake to.
     */
    protected void rotateArm(double degrees) {
        if (degrees > 0) {
            robot.arm.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.arm.setDirection(Servo.Direction.REVERSE);
        }

        robot.arm.setPosition(Utilities.degreesToGoBildaServoPosition(degrees));

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Turn the claw servo relative to its current position.
     *
     * @param degrees The angle to turn the intake for.
     */
    protected void turnArm(double degrees) {
        double position = Utilities.degreesToGoBildaServoPosition(degrees);
        double lastPosition = robot.arm.getPosition();
        if (robot.arm.getDirection() == Servo.Direction.REVERSE) {
            lastPosition = -lastPosition;
        }

        double delta = lastPosition + position;

        if (delta > 0.0) {
            robot.arm.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.arm.setDirection(Servo.Direction.REVERSE);
        }

        robot.arm.setPosition(Utilities.degreesToGoBildaServoPosition(delta));

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Rotate the foundation servos to specific positions.
     *
     * @param degrees The angle to turn the intake to.
     */
    protected void rotateFoundation(double degrees) {
        if (degrees > 0) {
            robot.leftFoundation.setDirection(Servo.Direction.FORWARD);
            robot.rightFoundation.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.leftFoundation.setDirection(Servo.Direction.REVERSE);
            robot.rightFoundation.setDirection(Servo.Direction.REVERSE);
        }

        double position = Utilities.degreesToGoBildaServoPosition(degrees);
        robot.leftFoundation.setPosition(position);
        robot.rightFoundation.setPosition(position);

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Turn the foundation servos relative to their current positions.
     *
     * @param degrees The angle to turn the intake for.
     */
    protected void turnFoundation(double degrees) {
        double position = Utilities.degreesToGoBildaServoPosition(degrees);
        double lastPosition = robot.arm.getPosition();
        if (robot.arm.getDirection() == Servo.Direction.REVERSE) {
            lastPosition = -lastPosition;
        }

        double delta = lastPosition + position;

        if (delta > 0) {
            robot.leftFoundation.setDirection(Servo.Direction.FORWARD);
            robot.rightFoundation.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.leftFoundation.setDirection(Servo.Direction.REVERSE);
            robot.rightFoundation.setDirection(Servo.Direction.REVERSE);
        }

        double deltaPosition = Utilities.degreesToGoBildaServoPosition(delta);
        robot.leftFoundation.setPosition(deltaPosition);
        robot.rightFoundation.setPosition(deltaPosition);

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Expand the foundation arms.
     */
    protected void expandFoundation() {
        robot.leftFoundation.setPosition(0.70);
        robot.rightFoundation.setPosition(0.70);
    }

    /**
     * Contract the foundation arms.
     */
    protected void contractFoundation() {
        robot.leftFoundation.setPosition(0.25);
        robot.rightFoundation.setPosition(0.25);
    }

    /**
     * Expand the arm.
     */
    protected void expandArm() {
        robot.arm.setPosition(ARM_MAX);
    }

    /**
     * Contract the arm.
     */
    protected void contractArm() {
        robot.arm.setPosition(ARM_MIN);
    }

    /**
     * Open the claw.
     */
    protected void openClaw() {
        robot.leftClaw.setPosition(0.2);
        robot.rightClaw.setPosition(0.2);
    }

    /**
     * Close the claw.
     */
    protected void closeClaw() {
        robot.leftClaw.setPosition(0.8);
        robot.rightClaw.setPosition(0.8);
    }

    /**
     * Get the color, but it's fixed in a *special* way.
     *
     * @return The fixed color.
     */
    protected int fixedColor() {
        if ((robot.colorSensor.red() * robot.colorSensor.green()) / Math.pow(robot.colorSensor.blue(), 2) < 2) {
            return Color.BLACK;
        } else {
            return robot.colorSensor.argb();
        }
    }

    /**
     * Get the orientation of the robot.
     * @return The current orientation of the robot.
     */
    protected double getOrientation(){
        return (-robot.imu.getAngularOrientation().firstAngle);
    }
}
