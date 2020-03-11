package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue building side near the wall.
 */
@Autonomous(name = "Right to Skybridge Autonomous", group = "Robot Autonomous")
//@Disabled
public class RightToSkybridgeAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            robot.drive.forward(0.25, Constants.MOVEMENT_FROM_WALL_DURATION);
            robot.drive.right(0.25, Constants.MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
