package org.firstinspires.ftc.teamcode.robot;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Utilities;

/**
 * An opmode with many utility methods and constants for autonomous programs.
 */
public class RobotLinearOpMode extends LinearOpMode {
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

        sleep(Constants.INITIAL_DELAY_DURATION);
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
     * @see Constants#MOVEMENT_PADDING_DURATION
     */
    protected void driveRaw(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        enable(frontLeftPower, frontRightPower, backLeftPower, backRightPower);

        sleep(duration);

        disable();

        sleep(Constants.MOVEMENT_PADDING_DURATION);
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
     * Expand the foundation arms.
     */
    protected void expandFoundation() {
        robot.leftFoundation.setPosition(0.70);
        robot.rightFoundation.setPosition(0.70);

        sleep(Constants.MOVEMENT_PADDING_DURATION);
    }

    /**
     * Contract the foundation arms.
     */
    protected void contractFoundation() {
        robot.leftFoundation.setPosition(0.25);
        robot.rightFoundation.setPosition(0.25);

        sleep(Constants.MOVEMENT_PADDING_DURATION);
    }

    /**
     * Expand the arm.
     */
    protected void expandArm() {
        robot.arm.setPosition(Constants.ARM_MAX);

        sleep(Constants.MOVEMENT_PADDING_DURATION);
    }

    /**
     * Contract the arm.
     */
    protected void contractArm() {
        robot.arm.setPosition(Constants.ARM_MIN);

        sleep(Constants.MOVEMENT_PADDING_DURATION);
    }

    /**
     * Open the claw.
     */
    protected void openClaw() {
        robot.leftClaw.setPosition(Constants.LEFT_CLAW_MIN);
        robot.rightClaw.setPosition(Constants.RIGHT_CLAW_MIN);

        sleep(Constants.MOVEMENT_PADDING_DURATION);
    }

    /**
     * Close the claw.
     */
    protected void closeClaw() {
        robot.leftClaw.setPosition(Constants.LEFT_CLAW_MAX);
        robot.rightClaw.setPosition(Constants.RIGHT_CLAW_MAX);

        sleep(Constants.MOVEMENT_PADDING_DURATION);
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
