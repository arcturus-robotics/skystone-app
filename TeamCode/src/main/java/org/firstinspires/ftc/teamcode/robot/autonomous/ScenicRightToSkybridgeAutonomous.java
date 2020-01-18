package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue building side near the wall.
 */
@Autonomous(name = "(Scenic) Right to Skybridge Autonomous", group = "Robot Autonomous")
//@Disabled
public class ScenicRightToSkybridgeAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(0.5, Constants.SCENIC_MOVEMENT_FROM_WALL_DURATION);
            driveRight(0.5, Constants.SCENIC_MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
