package org.firstinspires.ftc.teamcode.robot.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue loading side near the wall.
 */
@Autonomous(name = "Red: Loading Side (Wall) Autonomous", group = "Robot Autonomous")
//@Disabled
public class Red_LoadingSide_Wall_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(MOVEMENT_FROM_WALL_DURATION);
            driveRight(MOVEMENT_TO_SKYBRIDGE_DURATION);
        }
    }
}
