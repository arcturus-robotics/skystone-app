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
            robot.arm.contract();
            robot.arm.open();
            robot.drive.right(0.25, 3000);
        }

        boolean forward = true;
        while (opModeIsActive()) {
            int color = fixedColor();

            if (color == Color.BLACK) {
                telemetry.addData("Found", "black");
                telemetry.update();

                //grab the claw
                robot.drive.right(0.25, 250);
                robot.arm.expand();
                robot.arm.close();
                robot.arm.contract();

                //move to the foundation for pla
                robot.drive.left(0.25, 1300);
                robot.drive.forward(0.25, 4250);
                robot.drive.right(0.25, 1450);
                robot.arm.expand();
                robot.arm.open();
                robot.arm.contract();
                sleep(80);

                //move back and grab foundation
                robot.drive.left(0.25, 250);
                robot.drive.turnRight(0.25, 1200);
                sleep(100);

                robot.drive.forward(0.25, 125);
                robot.foundation.open();
                sleep(1000);
                robot.drive.turnLeft(0.25, 1500);
                sleep(80);
                robot.drive.left(0.25, 100);
                robot.foundation.close();

                //pickup the other skystone
                //robot.drive.right(0.25, 1300);
                //robot.arm.expand();
                //robot.arm.close();
                //robot.arm.contract();

                /*
                robot.foundation.open();
                robot.drive.right(0.25, 2900);
                robot.foundation.close();
                robot.drive.backward(0.25, 2900);
                robot.drive.right(0.25, 2900);
                */
                break;
            } else {
                telemetry.addData("Found", color);
                telemetry.update();
            }


            for (int is = 0; is % 120 == 0; is += 1) {
                robot.drive.backward(0.15, 100);
            }

            /*
            )
            if (i % 120 == 0) {
                forward = !forward;
            }


            if (forward) {
                robot.drive.forward(0.15, 100);
            } else {
                robot.drive.backward(0.15, 100);
            }

            i += 1;

             */

        }
    }

    /**
     * Get the color, but it's fixed in a *special* way.
     *
     * @return The fixed color.
     */
    protected int fixedColor() {
        if ((robot.sensors.color.red() * robot.sensors.color.green()) / Math.pow(robot.sensors.color.blue(), 2) < 2) {
            return Color.BLACK;
        } else {
            return robot.sensors.color.argb();
        }
    }
}
