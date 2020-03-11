package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.internal.system.AppUtil;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

import java.io.File;

@Autonomous(name = "Odometry Calibration Autonomous", group = "Autonomous")
public class OdometryCalibrationAutonomous extends RobotLinearOpMode {
    private double horizontalEncoderTickPerDegreeOffset = 0.0;

    // Configuration files.
    private File wheelBaseSeparationFile = AppUtil.getInstance().getSettingsFile("wheelBaseSeparation.txt");
    private File horizontalTickOffsetFile = AppUtil.getInstance().getSettingsFile("horizontalTickOffset.txt");

    @Override
    public void runOpMode() {
        super.runOpMode();

        //Begin calibration (if robot is unable to pivot at these speeds, please adjust the constant at the top of the code
        while (robot.imu.orientation() < 90 && opModeIsActive()) {
            robot.drive.start(0.5, -0.5, 0.5, -0.5);

            if (robot.imu.orientation() < 60) {
                robot.drive.start(0.25, -0.25, 0.25, -0.25);
            } else {
                robot.drive.start(0.125, -0.125, 0.125, -0.125);
            }

            telemetry.addData("IMU Angle", robot.imu.orientation());
            telemetry.update();
        }

        robot.drive.stop();

        period.reset();
        while (period.milliseconds() < 1000 && opModeIsActive()) {
            telemetry.addData("IMU Angle", robot.imu.orientation());
            telemetry.update();
        }

        double angle = robot.imu.orientation();

        // According to Wizards.exe:
        // Encoder difference is calculate with `leftEncoder - rightEncoder`.
        // Since the left encoder is also mapped to a drive motor, the encoder value needs to be negated.
        // This may need to be changed!
        double encoderDifference = Math.abs(robot.odometry.verticalLeft.getCurrentPosition()) + (Math.abs(robot.odometry.verticalRight.getCurrentPosition()));

        double verticalEncoderTickOffsetPerDegree = encoderDifference / angle;

        double wheelBaseSeparation = (2 * 90 * verticalEncoderTickOffsetPerDegree) / (Math.PI * Constants.TICKS_PER_INCH);

        horizontalEncoderTickPerDegreeOffset = robot.odometry.horizontal.getCurrentPosition() / Math.toRadians(robot.imu.orientation());

        //Write the constants to text files
        ReadWriteFile.writeFile(wheelBaseSeparationFile, String.valueOf(wheelBaseSeparation));
        ReadWriteFile.writeFile(horizontalTickOffsetFile, String.valueOf(horizontalEncoderTickPerDegreeOffset));

        while (opModeIsActive()) {
            telemetry.addData("Status", "Calibration complete!");

            // Display calculated constants.
            telemetry.addData("Wheel Base Separation", wheelBaseSeparation);
            telemetry.addData("Horizontal Encoder Offset", horizontalEncoderTickPerDegreeOffset);

            // Display raw values.
            telemetry.addData("IMU Angle", robot.imu.orientation());
            telemetry.addData("Vertical Left Position", -robot.odometry.verticalLeft.getCurrentPosition());
            telemetry.addData("Vertical Right Position", -robot.odometry.verticalRight.getCurrentPosition());
            telemetry.addData("Horizontal Position", -robot.odometry.horizontal.getCurrentPosition());
            telemetry.addData("Vertical Encoder Offset", verticalEncoderTickOffsetPerDegree);

            telemetry.update();
        }
    }
}
