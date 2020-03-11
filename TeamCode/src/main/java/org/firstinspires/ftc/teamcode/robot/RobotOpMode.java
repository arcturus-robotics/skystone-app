package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Implements methods for teleop for convenience.
 */
public class RobotOpMode extends OpMode {
    protected Robot robot;

    /**
     * Runs once upon initialization.
     */
    @Override
    public void init() {
        // Initialize the robot hardware using the hardware map.
        robot = new Robot(hardwareMap);

        telemetry.addData("Status", "Waiting...");
    }

    /**
     * Runs repeatedly after initialization but before playing.
     */
    @Override
    public void init_loop() {

    }

    /**
     * Runs once upon playing.
     */
    @Override
    public void start() {
        telemetry.addData("Status", "Started");
    }

    /**
     * Runs repeatedly after playing but before stopping.
     */
    @Override
    public void loop() {

    }

    /**
     * Code to run ONCE after the driver hits STOP.
     */
    @Override
    public void stop() {
        telemetry.addData("Status", "Stopped");
    }
}
