package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * A container for easy access to our robot's hardware.
 * Provides an easy way to initialize and reset devices.
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
    public static final String ATTACHMENT_SKYSTONE = "attachment_skystone";
    public static final String WEBCAM = "webcam";

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor odometryVerticalLeft;
    public DcMotor odometryVerticalRight;
    public DcMotor odometryHorizontal;
    public Servo intake;
    public Servo attachmentSkystone;
    public WebcamName webcam;

    private HardwareMap hardwareMap;
    private ElapsedTime period = new ElapsedTime();

    public RobotHardware() {
    }

    /**
     * Initialize the hardware map with each device on the robot.
     *
     * @param hwMap A reference to a hardware map.
     * @see RobotHardware#hardwareMap
     * @see #initDevice(String, DcMotor.Direction, DcMotor.RunMode)
     * @see #initDevice(String, Servo.Direction, double)
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

        // Initialize the odometry motors.
        odometryVerticalLeft = hardwareMap.get(DcMotor.class, ODOMETRY_VERTICAL_LEFT);
        odometryVerticalRight = hardwareMap.get(DcMotor.class, ODOMETRY_VERTICAL_RIGHT);
        odometryHorizontal = hardwareMap.get(DcMotor.class, ODOMETRY_HORIZONTAL);

        // Reset their encoders.
        odometryVerticalRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        odometryVerticalLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        odometryHorizontal.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set them to the proper directions.
        odometryVerticalLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        odometryVerticalRight.setDirection(DcMotorSimple.Direction.REVERSE);
        odometryHorizontal.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set them to run without an encoder.
        odometryVerticalRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        odometryVerticalLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        odometryHorizontal.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Initialize servos.
        intake = hardwareMap.get(Servo.class, INTAKE);
        attachmentSkystone = hardwareMap.get(Servo.class, ATTACHMENT_SKYSTONE);

        // Set them to the proper directions.
        intake.setDirection(Servo.Direction.FORWARD);
        attachmentSkystone.setDirection(Servo.Direction.FORWARD);

        // Reset their positions.
        intake.setPosition(1.0);
        attachmentSkystone.setPosition(0.0);

        // Initialize webcam.
        webcam = hardwareMap.get(WebcamName.class, WEBCAM);
    }

    /**
     * Initialize a motor.
     * NOTE: Use the opposite direction if you are using AndyMark motors.
     *
     * @return The initialized motor.
     * @param name      The motor's name.
     * @param direction The motor's direction.
     */
    private DcMotor initDevice(String name, DcMotor.Direction direction, DcMotor.RunMode runMode) {
        // Initialize the motor.
        DcMotor motor = hardwareMap.get(DcMotor.class, name);

        // Set the motor's direction.
        motor.setDirection(direction);

        // Reset the motor's power.
        motor.setPower(0.0);

        // Set the motor's run mode.
        motor.setMode(runMode);

        return motor;
    }

    /**
     * Initialize a servo with a specific direction.
     *
     * @return The initialized servo.
     * @param name       The servo's name.
     * @param direction  The servo's direction.
     */
    private Servo initDevice(String name, Servo.Direction direction) {
        // Initialize the servo.
        Servo servo = hardwareMap.get(Servo.class, name);

        // Set the servo's direction.
        servo.setDirection(direction);

        return servo;
    }

    /**
     * Initialize a servo with a specific direction and position.
     *
     * @return The initialized servo.
     * @param name       The servo's name.
     * @param direction  The servo's direction.
     * @param position   The servo's position.
     */
    private Servo initDevice(String name, Servo.Direction direction, double position) {
        // Initialize the servo.
        Servo servo = initDevice(name, direction);

        // Set the servo's position.
        servo.setPosition(position);

        return servo;
    }
}
