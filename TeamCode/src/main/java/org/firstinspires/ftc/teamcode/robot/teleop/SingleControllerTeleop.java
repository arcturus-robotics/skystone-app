package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Utilities;
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

    @Override
    public void loop() {
        // Calculate motor power based on input from the gamepad.
        float frontLeft = (float) -Utilities.clipDrive(gamepad1.left_stick_y - gamepad1.left_stick_x);
        float frontRight = (float) -Utilities.clipDrive(gamepad1.right_stick_y + gamepad1.right_stick_x);
        float backLeft = (float) -Utilities.clipDrive(gamepad1.left_stick_y + gamepad1.right_stick_x);
        float backRight = (float) -Utilities.clipDrive(gamepad1.right_stick_y - gamepad1.left_stick_x);

        // Drive the motors.
        robot.drive.start(frontLeft, frontRight, backLeft, backRight);

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
            robot.arm.maximizeLeftClaw();
        } else {
            robot.arm.minimizeLeftClaw();
        }

        if (rightClawState) {
            robot.arm.maximizeRightClaw();
        } else {
            robot.arm.minimizeRightClaw();
        }

        if (leftFoundationState) {
            robot.foundation.maximizeLeft();
        } else {
            robot.foundation.minimizeLeft();
        }

        if (rightFoundationState) {
            robot.foundation.maximizeRight();
        } else {
            robot.foundation.minimizeRight();
        }

        if (armState) {
            robot.arm.maximizeArm();
        } else {
            robot.arm.minimizeArm();
        }
    }
}
