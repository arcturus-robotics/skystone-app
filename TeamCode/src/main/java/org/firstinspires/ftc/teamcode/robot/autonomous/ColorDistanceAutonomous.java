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
            driveRight(0.5, 3000);
        }

        int i = 0;
        boolean forward = true;
        while (opModeIsActive()) {
            int color = fixedColor();

            if (color == Color.BLACK) {
                telemetry.addData("Found", "black");
                telemetry.update();

                driveLeft(0.5, 500);
                rotateArm(90.0);

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
