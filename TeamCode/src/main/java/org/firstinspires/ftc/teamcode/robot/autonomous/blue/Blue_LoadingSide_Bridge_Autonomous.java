package org.firstinspires.ftc.teamcode.robot.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue loading side near the bridge.
 */
@Autonomous(name = "Blue: Loading Side (Bridge) Autonomous", group = "Robot Autonomous")
//@Disabled
public class Blue_LoadingSide_Bridge_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(MOVEMENT_FROM_WALL_DURATION);
            driveLeft(MOVEMENT_TO_SKYBRIDGE_DURATION / 2);
        }
    }
}
