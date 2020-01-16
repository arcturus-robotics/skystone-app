package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.bosch.BNO055IMU;

/**
 * A container for easy access to our robot's hardware. Provides an easy way to
 * initialize and reset devices.
 */
public class RobotHardware {
    public static final String FRONT_LEFT_DRIVE = "front_left_drive";
    public static final String FRONT_RIGHT_DRIVE = "front_right_drive";
    public static final String BACK_LEFT_DRIVE = "back_left_drive";
    public static final String BACK_RIGHT_DRIVE = "back_right_drive";
    public static final String ODOMETRY_VERTICAL_LEFT = "odometry_vertical_left";
    public static final String ODOMETRY_VERTICAL_RIGHT = "odometry_vertical_right";
    public static final String ODOMETRY_HORIZONTAL = "odometry_horizontal";
    public static final String INTAKE = "intake";
    public static final String LEFT_INTAKE = "left_intake";
    public static final String RIGHT_INTAKE = "right_intake";
    public static final String COLOR_DISTANCE_SENSOR = "color_distance_sensor";
    public static final String WEBCAM = "webcam";
    public static final String IMU = "imu";

    public final double COLOR_SCALE_FACTOR = 255.0;

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor odometryVerticalLeft;
    public DcMotor odometryVerticalRight;
    public DcMotor odometryHorizontal;
    public Servo intake;
    public Servo leftIntake;
    public Servo rightIntake;
    public ColorSensor colorSensor;
    public DistanceSensor distanceSensor;
    public WebcamName webcam;
    public BNO055IMU imu;

    private HardwareMap hardwareMap;
    public ElapsedTime period = new ElapsedTime();

    public RobotHardware() {
    }

    /**
     * Initialize the hardware map with each device on the robot.
     *
     * @param hwMap A reference to a hardware map.
     * @see RobotHardware#hardwareMap
     */
    public void init(HardwareMap hwMap) {
        // Initialize the hardware map.
        hardwareMap = hwMap;

        // Initialize drive motors.
        frontLeftDrive = hardwareMap.get(DcMotor.class, FRONT_LEFT_DRIVE);
        frontRightDrive = hardwareMap.get(DcMotor.class, FRONT_RIGHT_DRIVE);
        backLeftDrive = hardwareMap.get(DcMotor.class, BACK_LEFT_DRIVE);
        backRightDrive = hardwareMap.get(DcMotor.class, BACK_RIGHT_DRIVE);

        // Set them to the proper directions.
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Reset their power.
        frontLeftDrive.setPower(0.0);
        frontRightDrive.setPower(0.0);
        backLeftDrive.setPower(0.0);
        backRightDrive.setPower(0.0);

        // Set them to run without an encoder.
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        /*
         * // Initialize the odometry motors. odometryVerticalLeft =
         * hardwareMap.get(DcMotor.class, ODOMETRY_VERTICAL_LEFT); odometryVerticalRight
         * = hardwareMap.get(DcMotor.class, ODOMETRY_VERTICAL_RIGHT); odometryHorizontal
         * = hardwareMap.get(DcMotor.class, ODOMETRY_HORIZONTAL);
         * 
         * // Stop and reset their encoders.
         * odometryVerticalRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         * odometryVerticalLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         * odometryHorizontal.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         * 
         * // Set them to the proper directions.
         * odometryVerticalLeft.setDirection(DcMotorSimple.Direction.REVERSE);
         * odometryVerticalRight.setDirection(DcMotorSimple.Direction.REVERSE);
         * odometryHorizontal.setDirection(DcMotorSimple.Direction.REVERSE);
         * 
         * // Set them to run without an encoder.
         * odometryVerticalRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         * odometryVerticalLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         * odometryHorizontal.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
         */

        // Initialize servos.
        intake = hardwareMap.get(Servo.class, INTAKE);
        leftIntake = hardwareMap.get(Servo.class, LEFT_INTAKE);
        rightIntake = hardwareMap.get(Servo.class, RIGHT_INTAKE);

        // Set them to the proper directions.
        intake.setDirection(Servo.Direction.FORWARD);
        leftIntake.setDirection(Servo.Direction.FORWARD);
        rightIntake.setDirection(Servo.Direction.FORWARD);

        // Reset their positions.
        intake.setPosition(1.0);
        leftIntake.setPosition(0.0);
        rightIntake.setPosition(0.0);

        // Initialize the color sensor.
        colorSensor = hardwareMap.get(ColorSensor.class, COLOR_DISTANCE_SENSOR);

        // Turn on the light of the color sensor.
        colorSensor.enableLed(true);

        // Initialize the distance sensor;
        distanceSensor = hardwareMap.get(DistanceSensor.class, COLOR_DISTANCE_SENSOR);

        // Initialize the webcam.
        webcam = hardwareMap.get(WebcamName.class, WEBCAM);

        // Initialize the IMU.
        imu = hardwareMap.get(BNO055IMU.class, IMU);

        // Initialize its parameters.
        BNO055IMU.Parameters imuParameters = new BNO055IMU.Parameters();
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imuParameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imuParameters.calibrationDataFile = "BN055IMUCalibration.json";
        imuParameters.loggingEnabled = true;
        imuParameters.loggingTag = "IMU";
        imuParameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu.initialize(imuParameters);
    }
}
