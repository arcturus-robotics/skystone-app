package org.firstinspires.ftc.teamcode.robot.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the building side near the wall.
 */
@Autonomous(name = "Red: Building Side (Wall)", group = "Robot Autonomous")
//@Disabled
public class Red_BuildingSide_Wall_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(1.0, 500);
        }
    }
}
