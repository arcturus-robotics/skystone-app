package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * A basic autonomous to move the foundation.
 */
@Autonomous(name = "Basic Foundation Autonomous", group = "Robot Autonomous")
//@Disabled
public class FoundationAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            contractFoundation();
            driveForward(0.5, 3100);
            expandFoundation();
            driveBackward(1.0, 5000);

        }
    }
}
