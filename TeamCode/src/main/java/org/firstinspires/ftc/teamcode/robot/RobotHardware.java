package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Constants;

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
    public static final String ARM = "arm";
    public static final String LEFT_CLAW = "gripper_left";
    public static final String RIGHT_CLAW = "gripper_right";
    public static final String LEFT_FOUNDATION = "left_foundation";
    public static final String RIGHT_FOUNDATION = "right_foundation";
    public static final String COLOR_DISTANCE_SENSOR = "color_distance_sensor";
    public static final String IMU = "imu";

    // Webcam isn't configured!
    // public static final String WEBCAM = "webcam";

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor odometryVerticalLeft;
    public DcMotor odometryVerticalRight;
    public DcMotor odometryHorizontal;
    public Servo arm;
    public Servo leftClaw;
    public Servo rightClaw;
    public Servo leftFoundation;
    public Servo rightFoundation;
    public ColorSensor colorSensor;
    public DistanceSensor distanceSensor;

    public BNO055IMU imu;

    // Webcam isn't configured!
    // public WebcamName webcam;
    public ElapsedTime period = new ElapsedTime();
    private HardwareMap hardwareMap;

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
         * // Initialize the odometry motors.
         * odometryVerticalLeft = hardwareMap.get(DcMotor.class, ODOMETRY_VERTICAL_LEFT);
         * odometryVerticalRight = hardwareMap.get(DcMotor.class, ODOMETRY_VERTICAL_RIGHT);
         * odometryHorizontal = hardwareMap.get(DcMotor.class, ODOMETRY_HORIZONTAL);
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
        arm = hardwareMap.get(Servo.class, ARM);
        leftClaw = hardwareMap.get(Servo.class, LEFT_CLAW);
        rightClaw = hardwareMap.get(Servo.class, RIGHT_CLAW);
        leftFoundation = hardwareMap.get(Servo.class, LEFT_FOUNDATION);
        rightFoundation = hardwareMap.get(Servo.class, RIGHT_FOUNDATION);

        // Set them to the proper directions.
        arm.setDirection(Servo.Direction.FORWARD);
        leftClaw.setDirection(Servo.Direction.REVERSE);
        rightClaw.setDirection(Servo.Direction.FORWARD);
        leftFoundation.setDirection(Servo.Direction.FORWARD);
        rightFoundation.setDirection(Servo.Direction.REVERSE);


        // Reset their positions.
        arm.setPosition(Constants.ARM_INIT);
        leftClaw.setPosition(Constants.LEFT_CLAW_INIT);
        rightClaw.setPosition(Constants.RIGHT_CLAW_INIT);
        leftFoundation.setPosition(Constants.LEFT_FOUNDATION_INIT);
        rightFoundation.setPosition(Constants.RIGHT_FOUNDATION_INIT);

        // Initialize the color sensor.
        colorSensor = hardwareMap.get(ColorSensor.class, COLOR_DISTANCE_SENSOR);

        // Turn on the light of the color sensor.
        colorSensor.enableLed(true);

        // Initialize the distance sensor;
        distanceSensor = hardwareMap.get(DistanceSensor.class, COLOR_DISTANCE_SENSOR);

        // Initialize the webcam (not configured).
        // webcam = hardwareMap.get(WebcamName.class, WEBCAM);

        // Initialize the IMU.
        imu = hardwareMap.get(BNO055IMU.class, IMU);

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
