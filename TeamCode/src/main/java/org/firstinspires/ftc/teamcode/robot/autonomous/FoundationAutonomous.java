package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

import org.firstinspires.ftc.teamcode.Constants;

/**
 * A basic autonomous to move the foundation.
 */
@Autonomous(name = "Basic Foundation Autonomous", group = "Robot Autonomous")
//@Disabled
public class FoundationAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            contractFoundation();
            driveLeft(0.5, Constants.MOVEMENT_FROM_WALL_DURATION);
            expandFoundation();
            driveRight(0.5, Constants.MOVEMENT_FROM_WALL_DURATION);
            contractFoundation();
            driveForward(0.5, Constants.MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
