package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * A basic autonomous to move the foundation.
 */
@Autonomous(name = "Right From Foundation Autonomous", group = "Robot Autonomous")
//@Disabled
public class RightFromFoundationAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            contractFoundation();
            sleep(2000);
            driveForward(0.25, 3000);
            expandFoundation();
            sleep(2000);
            driveBackward(0.5, 5000);
            contractFoundation();
            sleep(2000);
            driveRight(0.25, 3000);
        }
    }
}
