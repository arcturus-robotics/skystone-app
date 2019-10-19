package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Implements methods for teleop for convenience.
 */
public class RobotOpMode extends OpMode {
    public static final double BUTTON_THRESHOLD = 0.5;

    protected RobotHardware robot = new RobotHardware();
    protected ElapsedTime period = new ElapsedTime();

    /*
     * Code to run ONCE when the driver hits INIT.
     */
    @Override
    public void init() {
        // Initialize the robot hardware using the hardware map.
        robot.init(hardwareMap);

        telemetry.addData("Status", "Waiting...");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY.
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY.
     */
    @Override
    public void start() {
        telemetry.addData("Status", "Started");
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP.
     */
    @Override
    public void loop() {

    }

    /*
     * Code to run ONCE after the driver hits STOP.
     */
    @Override
    public void stop() {
        telemetry.addData("Status", "Stopped");
    }
}
