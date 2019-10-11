package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the foundation side near the bridge.
 */
@Autonomous(name = "Foundation Autonomous (Bridge)", group = "Robot Autonomous")
//@Disabled
public class FoundationBridgeAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            driveLeft(1.0, 500);
            driveForward(1.0, 1500);
        }
    }
}
