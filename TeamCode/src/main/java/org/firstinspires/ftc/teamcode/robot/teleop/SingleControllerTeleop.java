package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * A teleop for use with a single controller.
 */
@TeleOp(name = "Single Controller Teleop", group = "Robot Teleop")
//@Disabled
public class SingleControllerTeleop extends RobotOpMode {
    private boolean leftClawState = false;
    private boolean rightClawState = false;
    private boolean leftFoundationState = false;
    private boolean rightFoundationState = false;
    private boolean armState = false;

    private static final double FOUNDATION_MAX = 0.75;
    private static final double FOUNDATION_MIN = 0.25;
    private static final double LEFT_CLAW_MAX = 0.8;
    private static final double LEFT_CLAW_MIN = 0.2;
    private static final double RIGHT_CLAW_MAX = 1.0;
    private static final double RIGHT_CLAW_MIN = 0.0;
    private static final double ARM_MAX = 1.0;
    private static final double ARM_MIN = 0.125;

    @Override
    public void loop() {
        // Calculate motor power based on input from the gamepad.
        float frontLeft = -Range.clip(gamepad1.left_stick_y - gamepad1.left_stick_x, -1.0f, 1.0f);
        float frontRight = -Range.clip(gamepad1.right_stick_y + gamepad1.right_stick_x, -1.0f, 1.0f);
        float backLeft = -Range.clip(gamepad1.left_stick_y + gamepad1.right_stick_x, -1.0f, 1.0f);
        float backRight = -Range.clip(gamepad1.right_stick_y - gamepad1.left_stick_x, -1.0f, 1.0f);

        // Drive the motors.
        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);

        if (!(gamepad1.x && gamepad1.y)) {
            if (gamepad1.x) {
                leftClawState = true;
                rightClawState = true;
            }

            if (gamepad1.y) {
                leftClawState = false;
                rightClawState = false;
            }
        }

        if (!(gamepad1.dpad_down && gamepad1.dpad_up)) {
            if (gamepad1.dpad_down) {
                leftFoundationState = true;
                rightFoundationState = true;
            }

            if (gamepad1.dpad_up) {
                leftFoundationState = false;
                rightFoundationState = false;
            }
        }

        if (!(gamepad1.a && gamepad1.b)) {
            if (gamepad1.a) {
                armState = true;
            }

            if (gamepad1.b) {
                armState = false;
            }
        }

        if (leftClawState) {
            robot.leftClaw.setPosition(LEFT_CLAW_MAX);
        } else {
            robot.leftClaw.setPosition(LEFT_CLAW_MIN);
        }

        if (rightClawState) {
            robot.rightClaw.setPosition(RIGHT_CLAW_MAX);
        } else {
            robot.rightClaw.setPosition(RIGHT_CLAW_MIN);
        }

        if (leftFoundationState) {
            robot.leftFoundation.setPosition(FOUNDATION_MAX);
        } else {
            robot.leftFoundation.setPosition(FOUNDATION_MIN);
        }

        if (rightFoundationState) {
            robot.rightFoundation.setPosition(FOUNDATION_MAX);
        } else {
            robot.rightFoundation.setPosition(FOUNDATION_MIN);
        }

        if (armState) {
            robot.arm.setPosition(ARM_MAX);
        } else {
            robot.arm.setPosition(ARM_MIN);
        }

        telemetry.addData("Left Foundation Position", robot.leftFoundation.getPosition());
        telemetry.update();
    }
}
