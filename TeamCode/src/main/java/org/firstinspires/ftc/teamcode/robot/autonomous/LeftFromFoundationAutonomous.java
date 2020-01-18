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
            driveLeft(0.25, 1000);
            contractFoundation();
            sleep(2000);
            driveForward(0.25, 1700);
            expandFoundation();
            sleep(2000);
            driveBackward(0.5, 2100);
            turnRight(0.25, 1000);
            contractFoundation();
            sleep(2000);
            //driveRight(0.25, 3000);
        }
    }
}
