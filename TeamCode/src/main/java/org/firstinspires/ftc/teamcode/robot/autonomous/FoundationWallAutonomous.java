package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the foundation side near the wall.
 */
@Autonomous(name = "Foundation Autonomous (Wall)", group = "Robot Autonomous")
//@Disabled
public class FoundationWallAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(1.0, 500);
        }
    }
}
