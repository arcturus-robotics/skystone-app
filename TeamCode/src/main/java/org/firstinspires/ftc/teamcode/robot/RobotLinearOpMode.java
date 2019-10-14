package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Constants;

import java.util.List;

/**
 * An opmode with many utility methods for autonomous programs.
 */
public class RobotLinearOpMode extends LinearOpMode {
    protected RobotHardware robot = new RobotHardware();
    protected ElapsedTime period = new ElapsedTime();

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
     * Utility function for driving.
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
     * @see Constants#MOVEMENT_PADDING_DURATION
     */
    public void drive(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, long duration) {
        robot.frontLeftDrive.setPower(frontLeftPower);
        robot.frontRightDrive.setPower(frontRightPower);
        robot.backLeftDrive.setPower(backLeftPower);
        robot.backRightDrive.setPower(backRightPower);

        sleep(duration);

        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.backRightDrive.setPower(0);

        sleep(Constants.MOVEMENT_PADDING_DURATION);
    }

    /**
     * Drive forward.
     *
     * @param power    The drive power.
     * @param duration The duration to drive for.
     */
    public void driveForward(double power, long duration) {
        drive(
                power, power,
                power, power,
                duration
        );
    }

    /**
     * Drive left.
     *
     * @param power    The drive power.
     * @param duration The duration to drive for.
     */
    public void driveLeft(double power, long duration) {
        drive(
                power, -power,
                -power, power,
                duration
        );
    }

    /**
     * Drive backward.
     *
     * @param power    The drive power.
     * @param duration The duration to drive for.
     */
    public void driveBackward(double power, long duration) {
        drive(
                -power, -power,
                -power, -power,
                duration
        );
    }

    /**
     * Drive right.
     *
     * @param power    The drive power.
     * @param duration The duration to drive for.
     */
    public void driveRight(double power, long duration) {
        drive(
                -power, power,
                power, -power,
                duration
        );
    }

    /**
     * Turn left.
     *
     * @param power    The drive power.
     * @param duration The duration to drive for.
     */
    public void turnLeft(double power, long duration) {
        drive(
                -power, power,
                -power, power,
                duration
        );
    }

    /**
     * Turn right.
     *
     * @param power    The drive power.
     * @param duration The duration to drive for.
     */
    public void turnRight(double power, long duration) {
        drive(
                power, -power,
                power, -power,
                duration
        );
    }
}
