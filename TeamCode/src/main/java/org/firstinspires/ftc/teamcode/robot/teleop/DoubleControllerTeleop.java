package org.firstinspires.ftc.teamcode.robot.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;

/**
 * A teleop for use with two controllers.
 *
 * One controller drives and another controls intake.
 */
@TeleOp(name = "Double Controller Teleop", group = "Robot Teleop")
//@Disabled
public class DoubleControllerTeleop extends RobotOpMode {
    @Override
    public void loop() {
        // Calculate motor power based on input from the gamepad.
        float frontLeft = -Range.clip(gamepad1.left_stick_y + gamepad1.left_stick_x, -1.0f, 1.0f);
        float frontRight = -Range.clip(gamepad1.right_stick_y - gamepad1.right_stick_x, -1.0f, 1.0f);
        float backLeft = -Range.clip(gamepad1.left_stick_y - gamepad1.right_stick_x, -1.0f, 1.0f);
        float backRight = -Range.clip(gamepad1.right_stick_y + gamepad1.left_stick_x, -1.0f, 1.0f);

        // Drive the motors.
        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);

        // Rotate intake servo.
        if (gamepad2.y || gamepad2.b) {
            if (gamepad2.y) {
                robot.intake.setDirection(Servo.Direction.REVERSE);
            } else {
                robot.intake.setDirection(Servo.Direction.FORWARD);
            }

            robot.intake.setPosition(1);
        } else {
            robot.intake.setPosition(0);
        }
    }
}
