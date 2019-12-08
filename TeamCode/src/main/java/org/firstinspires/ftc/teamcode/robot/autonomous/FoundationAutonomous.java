package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

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
            driveLeft(0.5, MOVEMENT_FROM_WALL_DURATION);
            rotateIntake(360.0);
            driveRight(0.5,MOVEMENT_FROM_WALL_DURATION);
            rotateIntake(0.0);
            driveForward(0.5, MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
