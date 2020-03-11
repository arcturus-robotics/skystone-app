package org.firstinspires.ftc.teamcode.robot;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Utilities;

/**
 * An opmode with many utility methods and constants for autonomous programs.
 */
public class RobotLinearOpMode extends LinearOpMode {
    protected Robot robot;
    protected ElapsedTime period = new ElapsedTime();

    /**
     * Run the opmode.
     */
    @Override
    public void runOpMode() {
        // Initialize the robot using the hardware map.
        robot = new Robot(hardwareMap);

        // Wait until the driver presses PLAY.
        waitForStart();

        // Reset the elapsed time so we can accurately measure it.
        period.reset();

        sleep(Constants.INITIAL_DELAY_DURATION);
    }
}
