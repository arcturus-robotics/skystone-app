package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import android.graphics.Color;
import org.firstinspires.ftc.teamcode.Utilities;

/**
 * An opmode with many utility methods and constants for autonomous programs.
 */
public class RobotLinearOpMode extends LinearOpMode {
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
     * Utility function for driving.
     * Takes power for each drive motor and the duration to drive for.
     *
     * @param frontLeftPower  The power to drive the front left drive motor with.
     * @param frontRightPower The power to drive the front right  drive motor with.
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
        robot.frontLeftDrive.setPower(frontLeftPower);
        robot.frontRightDrive.setPower(frontRightPower);
        robot.backLeftDrive.setPower(backLeftPower);
        robot.backRightDrive.setPower(backRightPower);

        sleep(duration);

        robot.frontLeftDrive.setPower(0.0);
        robot.frontRightDrive.setPower(0.0);
        robot.backLeftDrive.setPower(0.0);
        robot.backRightDrive.setPower(0.0);

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Utility function for driving.
     * Takes power for each drive motor
     * (but multiplies it by <code>drivePower</code>)
     * and the duration to drive for.
     *
     * @param frontLeftPower  The power to drive the front left drive motor with.
     * @param frontRightPower The power to drive the front right  drive motor with.
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
     * Rotate the intake servo to a specific position.
     *
     * @param degrees The angle to turn the intake to.
     */
    protected void rotateIntake(double degrees) {
        if (degrees > 0) {
            robot.intake.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.intake.setDirection(Servo.Direction.REVERSE);
        }

        robot.intake.setPosition(Utilities.degreesToServoPosition(Math.abs(degrees)));

        sleep(MOVEMENT_PADDING_DURATION);
    }

    /**
     * Turn the intake servo relative to its current position.
     *
     * @param degrees The angle to turn the intake for.
     */
    protected void turnIntake(double degrees) {
        double position = Utilities.degreesToServoPosition(degrees);
        double lastPosition = robot.intake.getPosition();
        if (robot.intake.getDirection() == Servo.Direction.REVERSE) {
            lastPosition = -lastPosition;
        }

        double delta = lastPosition + position;

        if (delta > 0.0) {
            robot.intake.setDirection(Servo.Direction.FORWARD);
        } else {
            robot.intake.setDirection(Servo.Direction.REVERSE);
        }

        robot.intake.setPosition(Utilities.degreesToServoPosition(Math.abs(delta)));

        sleep(MOVEMENT_PADDING_DURATION);
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
}
