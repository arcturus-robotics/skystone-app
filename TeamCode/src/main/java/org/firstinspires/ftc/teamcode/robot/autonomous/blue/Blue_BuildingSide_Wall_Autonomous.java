package org.firstinspires.ftc.teamcode.robot.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the building side near the wall.
 */
@Autonomous(name = "Blue: Building Side (Wall) Autonomous", group = "Robot Autonomous")
//@Disabled
public class Blue_BuildingSide_Wall_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(1.0, 100);
            driveRight(1.0, 400);
        }
    }
}
