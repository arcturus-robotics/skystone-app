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
            driveRight(0.25, 1000);
            contractFoundation();
            sleep(2000);
            driveForward(0.25, 1700);
            expandFoundation();
            sleep(2000);
            driveBackward(0.5, 2100);
            turnRight(0.25, 1000);
            contractFoundation();
            sleep(2000);
            //driveLeft(0.25, 2600);
            //driveForward(0.25, 1400);
            //driveRight(0.25, 700);
        }
    }
}
