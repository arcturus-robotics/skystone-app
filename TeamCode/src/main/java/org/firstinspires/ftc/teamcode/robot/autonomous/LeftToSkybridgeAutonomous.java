package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue building side near the wall.
 */
@Autonomous(name = "Left to Skybridge Autonomous", group = "Robot Autonomous")
//@Disabled
public class LeftToSkybridgeAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(0.5, Constants.MOVEMENT_FROM_WALL_DURATION);
            driveLeft(0.5, Constants.MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
