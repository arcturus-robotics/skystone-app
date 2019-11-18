package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * A container for easy access to our robot's hardware.
 * Provides an easy way to initialize and reset devices.
 *
 * <p>
 * Motors:
 * frontLeftDrive:  {@value #FRONT_LEFT_DRIVE}
 * frontRightDrive: {@value #FRONT_RIGHT_DRIVE}
 * backLeftDrive:   {@value #BACK_LEFT_DRIVE}
 * backRightDrive:  {@value #BACK_RIGHT_DRIVE}
 *
 * <p>
 * Servos:
 * intake: {@value #INTAKE}
 */
public class RobotHardware {
    public static final String FRONT_LEFT_DRIVE = "front_left_drive";
    public static final String FRONT_RIGHT_DRIVE = "front_right_drive";
    public static final String BACK_LEFT_DRIVE = "back_left_drive";
    public static final String BACK_RIGHT_DRIVE = "back_right_drive";
    public static final String INTAKE = "intake";
    public static final String ATTACHMENT_SKYSTONE = "attachment_skystone";
    public static final String WEBCAM = "webcam";

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
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
     * @see #initDevice(String, DcMotor.Direction)
     * @see #initDevice(String, Servo.Direction, double)
     */
    public void init(HardwareMap hwMap) {
        // Initialize the hardware map.
        hardwareMap = hwMap;

        // Initialize webcam.
        webcam = hardwareMap.get(WebcamName.class, WEBCAM);

        // Initialize motors.
        frontLeftDrive = initDevice(FRONT_LEFT_DRIVE, DcMotor.Direction.FORWARD);
        frontRightDrive = initDevice(FRONT_RIGHT_DRIVE, DcMotor.Direction.REVERSE);
        backLeftDrive = initDevice(BACK_LEFT_DRIVE, DcMotor.Direction.FORWARD);
        backRightDrive = initDevice(BACK_RIGHT_DRIVE, DcMotor.Direction.REVERSE);

        // Initialize servos.
        intake = initDevice(INTAKE, Servo.Direction.FORWARD, 1.0);
        attachmentSkystone = initDevice(ATTACHMENT_SKYSTONE, Servo.Direction.FORWARD, 0.0);
    }

    /**
     * Initialize a motor.
     * NOTE: Use the opposite direction if you are using AndyMark motors.
     *
     * @return The initialized motor.
     * @param name      The motor's name.
     * @param direction The motor's direction.
     */
    private DcMotor initDevice(String name, DcMotor.Direction direction) {
        // Initialize the motor.
        DcMotor motor = hardwareMap.get(DcMotor.class, name);

        // Set the motor's direction.
        motor.setDirection(direction);

        // Reset the motor's power.
        motor.setPower(0.0);

        // Set the motor to run without an encoder.
        // NOTE: We may want to use RUN_USING_ENCODER if we ever install encoders.
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
