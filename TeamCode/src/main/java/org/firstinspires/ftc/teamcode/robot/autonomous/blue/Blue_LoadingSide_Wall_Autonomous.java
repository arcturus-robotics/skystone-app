package org.firstinspires.ftc.teamcode.robot.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue loading side near the wall.
 */
@Autonomous(name = "Blue: Loading Side (Wall) Autonomous", group = "Robot Autonomous")
//@Disabled
public class Blue_LoadingSide_Wall_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(MOVEMENT_FROM_WALL_DURATION);
            driveLeft(MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
