package org.firstinspires.ftc.teamcode.robot.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the building side near the bridge.
 */
@Autonomous(name = "Red: Building Side (Bridge)", group = "Robot Autonomous")
//@Disabled
public class Red_BuildingSide_Bridge_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(1.0, 100);
            driveLeft(1.0, 400);
        }
    }
}
