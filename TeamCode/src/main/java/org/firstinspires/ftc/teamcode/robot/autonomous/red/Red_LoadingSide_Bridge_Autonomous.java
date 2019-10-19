package org.firstinspires.ftc.teamcode.robot.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue loading side near the bridge.
 */
@Autonomous(name = "Red: Loading Side (Bridge) Autonomous", group = "Robot Autonomous")
//@Disabled
public class Red_LoadingSide_Bridge_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(MOVEMENT_FROM_WALL_DURATION);
            driveRight(MOVEMENT_TO_SKYBRIDGE_DURATION / 2);
        }
    }
}
