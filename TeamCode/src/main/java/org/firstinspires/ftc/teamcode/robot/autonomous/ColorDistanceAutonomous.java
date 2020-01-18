package org.firstinspires.ftc.teamcode.robot.autonomous;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * Does things based on the input from color and distance
 */
@Autonomous(name = "Color Distance Autonomous", group = "Robot Autonomous")
//@Disabled
public class ColorDistanceAutonomous extends RobotLinearOpMode {
    //@Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            contractArm();
            openClaw();
            driveRight(0.5, 3000);
        }

        boolean forward = true;
        while (opModeIsActive()) {
            int color = fixedColor();

            if (color == Color.BLACK) {
                telemetry.addData("Found", "black");
                telemetry.update();

                //grab the claw
                driveRight(0.5, 250);
                expandArm();
                closeClaw();
                contractArm();

                //move to the foundation for pla
                driveLeft(0.5, 1300);
                driveForward(0.5, 4250);
                driveRight(0.5, 1450);
                expandArm();
                openClaw();
                contractArm();
                sleep(80);

                //move back and grab foundation
                driveLeft(0.5, 250);
                turnRight(0.5, 1200);
                sleep(100);

                driveForward(0.5, 125);
                expandFoundation();
                sleep(1000);
                turnLeft(0.5, 1500);
                sleep(80);
                driveLeft(0.5, 100);
                contractFoundation();

                //pickup the other skystone
                //driveRight(0.5, 1300);
                //expandArm();
                //closeClaw();
                //contractArm();

                /*
                expandFoundation();
                driveRight(0.5, 2900);
                contractFoundation();
                driveBackward(0.5, 2900);
                driveRight(0.5, 2900);
                */
                break;
            } else {
                telemetry.addData("Found", color);
                telemetry.update();
            }


            for (int is = 0; is % 120 == 0; is += 1) {
                driveBackward(0.3, 100);
            }

            /*
            )
            if (i % 120 == 0) {
                forward = !forward;
            }


            if (forward) {
                driveForward(0.3, 100);
            } else {
                driveBackward(0.3, 100);
            }

            i += 1;

             */

        }
    }
}
