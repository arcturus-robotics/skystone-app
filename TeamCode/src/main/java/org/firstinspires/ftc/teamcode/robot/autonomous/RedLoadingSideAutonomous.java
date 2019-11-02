package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue loading side near the wall.
 */
@Autonomous(name = "Red Loading Side Autonomous", group = "Robot Autonomous")
//@Disabled
public class RedLoadingSideAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(0.5, MOVEMENT_FROM_WALL_DURATION);
            driveRight(0.5, MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
