package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.components.Arm;
import org.firstinspires.ftc.teamcode.robot.components.Drive;
import org.firstinspires.ftc.teamcode.robot.components.Foundation;
import org.firstinspires.ftc.teamcode.robot.components.Imu;
import org.firstinspires.ftc.teamcode.robot.components.Odometry;
import org.firstinspires.ftc.teamcode.robot.components.Sensors;

public class Robot {
    public Arm arm;
    public Drive drive;
    public Foundation foundation;
    public Imu imu;
    public Odometry odometry;
    public Sensors sensors;

    public Robot() {}

    public Robot(HardwareMap hardwareMap) {
        arm = new Arm(
                hardwareMap.get(Servo.class, "arm"),
                hardwareMap.get(Servo.class, "left_claw"), hardwareMap.get(Servo.class, "right_claw")
        );

        drive = new Drive(
                hardwareMap.get(DcMotor.class, "front_left_drive"), hardwareMap.get(DcMotor.class, "front_right_drive"),
                hardwareMap.get(DcMotor.class, "back_left_drive"), hardwareMap.get(DcMotor.class, "back_right_drive")
        );

        foundation = new Foundation(
                hardwareMap.get(Servo.class, "left_foundation"), hardwareMap.get(Servo.class, "right_foundation")
        );

        imu = new Imu(
                hardwareMap.get(BNO055IMU.class, "imu")
        );

        odometry = new Odometry(
                hardwareMap.get(DcMotor.class, "odometry_vertical_left"), hardwareMap.get(DcMotor.class, "odometry_vertical_right"),
                hardwareMap.get(DcMotor.class, "odometry_horizontal")
        );

        sensors = new Sensors();
        sensors.color = hardwareMap.get(ColorSensor.class, "color_distance_sensor");
        sensors.distance = hardwareMap.get(DistanceSensor.class, "color_distance_sensor");
    }
}
