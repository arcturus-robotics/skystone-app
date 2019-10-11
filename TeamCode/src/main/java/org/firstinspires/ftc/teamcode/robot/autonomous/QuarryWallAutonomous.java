package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the quarry side near the wall.
 */
@Autonomous(name = "Quarry Autonomous (Wall)", group = "Robot Autonomous")
//@Disabled
public class QuarryWallAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveRight(1.0, 500);
            driveForward(1.0, 1500);
        }
    }
}
