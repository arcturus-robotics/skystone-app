package org.firstinspires.ftc.teamcode.robot.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue building side near the bridge.
 */
@Autonomous(name = "Blue: Building Side (Bridge) Autonomous", group = "Robot Autonomous")
//@Disabled
public class Blue_BuildingSide_Bridge_Autonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveForward(0.5, Constants.MOVEMENT_FROM_WALL_DURATION);
            driveRight(0.7, 2250);
        }
    }
}
