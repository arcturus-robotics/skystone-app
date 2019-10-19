package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * A container for our robot's hardware.
 *
 * <p>
 * Motors:
 * frontLeftDrive:  {@value #FRONT_LEFT_DRIVE}
 * frontRightDrive: {@value #FRONT_RIGHT_DRIVE}
 * backLeftDrive:   {@value #BACK_LEFT_DRIVE}
 * backRightDrive:  {@value #BACK_RIGHT_DRIVE}
 * intake:          {@value #INTAKE}
 */
public class RobotHardware {
    public static final String FRONT_LEFT_DRIVE = "front_left_drive";
    public static final String FRONT_RIGHT_DRIVE = "front_right_drive";
    public static final String BACK_LEFT_DRIVE = "back_left_drive";
    public static final String BACK_RIGHT_DRIVE = "back_right_drive";
    public static final String INTAKE = "intake";

    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public Servo intake;

    private HardwareMap hardwareMap;
    private ElapsedTime period = new ElapsedTime();

    public RobotHardware() {
    }

    /**
     * Initialize the hardware map with each device on the robot.
     *
     * @param hwMap A reference to a hardware map.
     * @see RobotHardware#hardwareMap
     * @see #initDevice(DcMotor, String, DcMotor.Direction)
     * @see #initDevice(Servo, String)
     */
    public void init(HardwareMap hwMap) {
        // Save a reference to the hardware map.
        hardwareMap = hwMap;

        // Initialize motors.
        initDevice(frontLeftDrive, FRONT_LEFT_DRIVE, DcMotor.Direction.FORWARD);
        initDevice(frontLeftDrive, FRONT_RIGHT_DRIVE, DcMotor.Direction.REVERSE);
        initDevice(frontLeftDrive, BACK_LEFT_DRIVE, DcMotor.Direction.FORWARD);
        initDevice(frontLeftDrive, BACK_RIGHT_DRIVE, DcMotor.Direction.REVERSE);

        // Initialize servos.
        //initDevice(intake, INTAKE, Servo.Direction.FORWARD, false);
    }

    /**
     * Initialize a motor.
     * NOTE: Use the opposite direction if you are using AndyMark motors.
     *
     * @param motor     The motor.
     * @param name      The motor's name.
     * @param direction The motor's direction.
     */
    private void initDevice(DcMotor motor, String name, DcMotor.Direction direction) {
        // Initialize the motor.
        motor = hardwareMap.get(DcMotor.class, name);

        // Set the motor's direction.
        motor.setDirection(direction);

        // Reset the motor's power.
        motor.setPower(0.0);

        // Set the motor to run without an encoder.
        // NOTE: We may want to use RUN_USING_ENCODER if we ever install encoders.
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /**
     * Initialize a servo.
     *
     * @param servo      The servo.
     * @param name       The servo's name.
     * @param direction  The servo's direction.
     * @param continuous Whether the servo is a continuous rotation servo or not.
     */
    private void initDevice(Servo servo, String name, Servo.Direction direction, boolean continuous) {
        // Initialize the servo.
        servo = hardwareMap.get(Servo.class, name);

        // Set the servo's direction.
        servo.setDirection(direction);

        // Reset the servo's position.
        if (continuous) {
            servo.setPosition(0.0);
        }
    }
}
