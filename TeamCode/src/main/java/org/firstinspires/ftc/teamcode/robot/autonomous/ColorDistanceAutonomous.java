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

        while (opModeIsActive()) {
            int color = fixedColor();

            if (color == Color.BLACK) {
                telemetry.addData("Found", "black");

                driveForward(0.5, 500);
                rotateIntake(360.0);
            } else {
                telemetry.addData("Found", "no black");

                driveForward(0.5, MOVEMENT_TO_SKYBRIDGE_DURATION);
                driveBackward(0.5, MOVEMENT_TO_SKYBRIDGE_DURATION);
            }

            telemetry.update();
        }
    }
}
