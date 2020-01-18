package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * A basic autonomous to move the foundation.
 */
@Autonomous(name = "Left From Foundation Autonomous", group = "Robot Autonomous")
//@Disabled
public class LeftFromFoundationAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            contractFoundation();
            sleep(2000);
            driveForward(0.5, 3100);
            expandFoundation();
            sleep(2000);
            driveBackward(1.0, 5000);
            contractFoundation();
            sleep(2000);
            driveLeft(0.5, 3000);
        }
    }
}
