package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Utilities;

public class Arm {
    /**
     * The arm servo.
     */
    public Servo arm;
    public double armMaximumPosition = 1.0;
    public double armMinimumPosition = 0.0;

    /**
     * The left claw servo.
     */
    public Servo leftClaw;
    public double leftClawMaximumPosition = 1.0;
    public double leftClawMinimumPosition = 0.0;

    /**
     * The right claw servo.
     */
    public Servo rightClaw;
    public double rightClawMaximumPosition = 1.0;
    public double rightClawMinimumPosition = 0.0;

    /**
     * The duration of time to sleep between servo movements.
     */
    public long padding = 0;

    public Arm(Servo arm, Servo leftClaw, Servo rightClaw) {
        this.arm = arm;
        this.leftClaw = leftClaw;
        this.rightClaw = rightClaw;

        initialize();
    }

    public Arm(Servo arm, double armInitializationPosition, Servo leftClaw, double leftClawInitializationPosition, Servo rightClaw, double rightClawInitializationPosition) {
        this.arm = arm;
        this.leftClaw = leftClaw;
        this.rightClaw = rightClaw;

        initialize(armInitializationPosition, leftClawInitializationPosition, rightClawInitializationPosition);
    }

    /**
     * Set the arm to its maximum position.
     */
    public void maximizeArm() {
        arm.setPosition(armMaximumPosition);
    }

    /**
     * Set the arm to its minimum position.
     */
    public void minimizeArm() {
        arm.setPosition(armMinimumPosition);
    }

    /**
     * Set the left claw to its maximum position.
     */
    public void maximizeLeftClaw() {
        leftClaw.setPosition(armMaximumPosition);
    }

    /**
     * Set the left claw to its minimum position.
     */
    public void minimizeLeftClaw() {
        leftClaw.setPosition(armMinimumPosition);
    }

    /**
     * Set the right claw to its maximum position.
     */
    public void maximizeRightClaw() {
        rightClaw.setPosition(armMaximumPosition);
    }

    /**
     * Set the right claw to its minimum position.
     */
    public void minimizeRightClaw() {
        rightClaw.setPosition(armMinimumPosition);
    }

    /**
     * Extend the arm.
     */
    public void extendArm() {
        maximizeArm();

        Utilities.sleep(padding);
    }

    /**
     * Contract the arm.
     */
    public void contractArm() {
        minimizeArm();

        Utilities.sleep(padding);
    }

    /**
     * Open the claw.
     */
    public void openClaw() {
        minimizeLeftClaw();
        minimizeRightClaw();

        Utilities.sleep(padding);
    }

    /**
     * Close the claw.
     */
    public void closeClaw() {
        maximizeLeftClaw();
        maximizeRightClaw();

        Utilities.sleep(padding);
    }

    /**
     * Initialize each of the servos to its proper configuration.
     */
    public void initialize(double armInitializationPosition, double leftClawInitializationPosition, double rightClawInitializationPosition) {
        arm.setDirection(Servo.Direction.FORWARD);
        leftClaw.setDirection(Servo.Direction.REVERSE);
        rightClaw.setDirection(Servo.Direction.FORWARD);

        arm.setPosition(armInitializationPosition);
        leftClaw.setPosition(leftClawInitializationPosition);
        rightClaw.setPosition(rightClawInitializationPosition);
    }

    /**
     * Initialize each of the servos to its proper configuration.
     * The initialization position of each servo is default here, so it's probably wrong!
     */
    public void initialize() {
        initialize(0.5, 0.5, 0.5);
    }
}
