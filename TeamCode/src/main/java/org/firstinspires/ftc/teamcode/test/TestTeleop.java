package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.RobotOpMode;
import com.qualcomm.robotcore.util.Range;

/**
 * A teleop for testing purposes.
 */
@TeleOp(name = "Test Teleop", group = "Robot Teleop")
//@Disabled
public class TestTeleop extends RobotOpMode {
    @Override
    public void loop() {
        // Calculate motor power based on input from the gamepad.
        float frontLeft = -Range.clip(gamepad1.left_stick_y + gamepad1.left_stick_x, -1, 1);
        float frontRight = -Range.clip(gamepad1.right_stick_y - gamepad1.right_stick_x, -1, 1);
        float backLeft = -Range.clip(gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1);
        float backRight = -Range.clip(gamepad1.right_stick_y + gamepad1.left_stick_x, -1, 1);

        // Drive the motors.
        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);
    }
}
