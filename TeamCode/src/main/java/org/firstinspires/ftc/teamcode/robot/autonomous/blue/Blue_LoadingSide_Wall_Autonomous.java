package org.firstinspires.ftc.teamcode.robot.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the loading side near the wall.
 */
@Autonomous(name = "Blue: Loading Side (Wall)", group = "Robot Autonomous")
//@Disabled
public class Blue_LoadingSide_Wall_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveRight(1.0, 500);
            driveForward(1.0, 1500);
        }
    }
}
