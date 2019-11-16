package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * An autonomous that starts on the blue building side near the wall.
 */
@Autonomous(name = "BasicFoundationMove", group = "Robot Autonomous")
//@Disabled
public class BasicFoundationMove extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            //move to foundation
            driveForward(0.5, MOVEMENT_FROM_WALL_DURATION);
            //put servo on foundation
            turnIntake(1.0);
            //move back
            driveBackward(0.5, MOVEMENT_TO_SKYBRIDGE_DURATION);
            //take servo off
            turnIntake(-1.0);
            //move right unde rbridge
            driveRight(0.5, 1);

        }
    }
}
