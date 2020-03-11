package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;
import org.firstinspires.ftc.teamcode.robot.odometry.OdometryPosition;

@Autonomous(name = "Odometry Position Update Autonomous", group = "Autonomous")
public class OdometryPositionUpdateAutonomous extends RobotLinearOpMode {
    @Override
    public void runOpMode() {
        super.runOpMode();

        // Initialize the position.
        OdometryPosition position = new OdometryPosition(
                robot.odometry.verticalLeft,
                robot.odometry.verticalRight,
                robot.odometry.horizontal,
                75,
                Constants.TICKS_PER_INCH,
                Constants.TICKS_PER_INCH,
                Constants.TICKS_PER_INCH
        );

        // Initialize and start the position updating thread.
        Thread positionThread = new Thread(position);
        positionThread.start();

        while (opModeIsActive()) {
            // Display (x, y, theta) coordinates.
            telemetry.addData("X Position", position.x() / Constants.TICKS_PER_INCH);
            telemetry.addData("Y Position", position.y() / Constants.TICKS_PER_INCH);
            telemetry.addData("Orientation", position.orientationDegrees());
            telemetry.addData("Thread State", positionThread.isAlive());
            telemetry.update();
        }

        // Stop the thread.
        position.stop();
    }
}