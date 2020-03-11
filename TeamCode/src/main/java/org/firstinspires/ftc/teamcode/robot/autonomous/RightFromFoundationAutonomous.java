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
            robot.drive.right(0.25, 1000);
            robot.foundation.close();
            sleep(2000);
            robot.drive.forward(0.25, 1700);
            robot.foundation.open();
            sleep(2000);
            robot.drive.backward(0.5, 2100);
            robot.drive.turnRight(0.6, 5000);
            robot.foundation.close();
            sleep(2000);
            //robot.drive.left(0.25, 2600);
            //robot.drive.forward(0.25, 1400);
            //robot.drive.right(0.25, 700);
        }
    }
}
