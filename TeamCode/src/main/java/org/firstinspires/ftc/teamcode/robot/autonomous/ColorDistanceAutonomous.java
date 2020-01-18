package org.firstinspires.ftc.teamcode.robot.autonomous;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * Does things based on the input from color and distance
 */
@Autonomous(name = "Color Distance Autonomous", group = "Robot Autonomous")
//@Disabled
public class ColorDistanceAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            openClaw();
            driveRight(0.5, 2900);
        }

        int i = 0;
        boolean forward = true;
        while (opModeIsActive()) {
            int color = fixedColor();

            if (color == Color.BLACK) {
                telemetry.addData("Found", "black");
                telemetry.update();

                driveRight(0.5, 250);
                expandArm();
                closeClaw();

                break;
            } else {
                telemetry.addData("Found", color);
                telemetry.update();
            }

            if (i % 120 == 0) {
                forward = !forward;
            }

            if (forward) {
                driveForward(0.3, 100);
            } else {
                driveBackward(0.3, 100);
            }

            i += 1;
        }
    }
}
