package org.firstinspires.ftc.teamcode.robot.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the loading side near the wall.
 */
@Autonomous(name = "Red: Loading Side (Wall)", group = "Robot Autonomous")
//@Disabled
public class Red_LoadingSide_Wall_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveRight(1.0, 500);
            driveForward(1.0, 1500);
        }
    }
}
