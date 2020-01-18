package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Utilities;
import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * A teleop for use with two controllers.
 * <p>
 * One controller drives and another controls intake.
 */
@TeleOp(name = "Double Controller Teleop", group = "Robot Teleop")
//@Disabled
public class DoubleControllerTeleop extends RobotOpMode {
    private boolean leftClawState = false;
    private boolean rightClawState = false;
    private boolean leftFoundationState = false;
    private boolean rightFoundationState = false;
    private boolean armState = false;

    @Override
    public void loop() {
        // Calculate motor power based on input from the gamepad.
        float frontLeft = (float) -Utilities.clipDrive(gamepad1.left_stick_y - gamepad1.left_stick_x);
        float frontRight = (float) -Utilities.clipDrive(gamepad1.right_stick_y + gamepad1.right_stick_x);
        float backLeft = (float) -Utilities.clipDrive(gamepad1.left_stick_y + gamepad1.right_stick_x);
        float backRight = (float) -Utilities.clipDrive(gamepad1.right_stick_y - gamepad1.left_stick_x);

        // Drive the motors.
        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);

        if (!(gamepad2.x && gamepad2.y)) {
            if (gamepad2.x) {
                leftClawState = true;
                rightClawState = true;
            }

            if (gamepad2.y) {
                leftClawState = false;
                rightClawState = false;
            }
        }

        if (!(gamepad2.dpad_down && gamepad2.dpad_up)) {
            if (gamepad2.dpad_down) {
                leftFoundationState = true;
                rightFoundationState = true;
            }

            if (gamepad2.dpad_up) {
                leftFoundationState = false;
                rightFoundationState = false;
            }
        }

        if (!(gamepad2.a && gamepad2.b)) {
            if (gamepad2.a) {
                armState = true;
            }

            if (gamepad2.b) {
                armState = false;
            }
        }

        if (leftClawState) {
            robot.leftClaw.setPosition(Constants.LEFT_CLAW_MAX);
        } else {
            robot.leftClaw.setPosition(Constants.LEFT_CLAW_MIN);
        }

        if (rightClawState) {
            robot.rightClaw.setPosition(Constants.RIGHT_CLAW_MAX);
        } else {
            robot.rightClaw.setPosition(Constants.RIGHT_CLAW_MIN);
        }

        if (leftFoundationState) {
            robot.leftFoundation.setPosition(Constants.LEFT_FOUNDATION_MAX);
        } else {
            robot.leftFoundation.setPosition(Constants.LEFT_FOUNDATION_MIN);
        }

        if (rightFoundationState) {
            robot.rightFoundation.setPosition(Constants.RIGHT_FOUNDATION_MAX);
        } else {
            robot.rightFoundation.setPosition(Constants.RIGHT_FOUNDATION_MIN);
        }

        if (armState) {
            robot.arm.setPosition(Constants.ARM_MAX);
        } else {
            robot.arm.setPosition(Constants.ARM_MIN);
        }
    }
}
