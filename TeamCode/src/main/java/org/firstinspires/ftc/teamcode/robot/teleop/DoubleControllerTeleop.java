package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * A teleop for use with two controllers.
 * <p>
 * One controller drives and another controls intake.
 */
@TeleOp(name = "Double Controller Teleop", group = "Robot Teleop")
//@Disabled
public class DoubleControllerTeleop extends RobotOpMode {
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

        // Rotate the claws.
        if (gamepad2.x || gamepad2.y) {
            if (gamepad2.x) {
                robot.leftClaw.setDirection(Servo.Direction.REVERSE);
                robot.rightClaw.setDirection(Servo.Direction.FORWARD);
            } else {
                robot.leftClaw.setDirection(Servo.Direction.FORWARD);
                robot.rightClaw.setDirection(Servo.Direction.REVERSE);
            }
            robot.leftClaw.setPosition(1.0);
            robot.rightClaw.setPosition(1.0);
        } else {
            robot.leftClaw.setPosition(0.0);
            robot.rightClaw.setPosition(0.0);
        }

        // Rotate the arm.
        if (gamepad2.a || gamepad2.b) {
            if (gamepad2.a) {
                robot.arm.setDirection(Servo.Direction.REVERSE);
            } else {
                robot.arm.setDirection(Servo.Direction.FORWARD);
            }
            robot.arm.setPosition(1.0);
        } else {
            robot.arm.setPosition(0.0);
        }

        // Rotate the foundation servos.
        if (gamepad2.dpad_down || gamepad2.dpad_up) {
            if (gamepad2.dpad_down) {
                robot.leftFoundation.setDirection(Servo.Direction.REVERSE);
                robot.rightFoundation.setDirection(Servo.Direction.REVERSE);
            } else {
                robot.leftFoundation.setDirection(Servo.Direction.FORWARD);
                robot.rightFoundation.setDirection(Servo.Direction.REVERSE);
            }
            robot.leftFoundation.setPosition(1.0);
            robot.rightFoundation.setPosition(1.0);
        } else {
            robot.leftFoundation.setPosition(0.0);
            robot.rightFoundation.setPosition(0.0);
        }
    }
}
