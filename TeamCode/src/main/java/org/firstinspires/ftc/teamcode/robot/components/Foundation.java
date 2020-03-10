package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Utilities;

public class Foundation {
    public Servo left;
    public double leftMaximumPosition = 1.0;
    public double leftMinimumPosition = 0.0;

    public Servo right;
    public double rightMaximumPosition = 1.0;
    public double rightMinimumPosition = 0.0;

    public long padding;

    public Foundation(Servo left, Servo right) {
        this.left = left;
        this.right = right;

        initialize();
    }

    public Foundation(Servo left, double leftInitializationPosition, Servo right, double rightInitializationPosition) {
        this.left = left;
        this.right = right;

        initialize(leftInitializationPosition, rightInitializationPosition);
    }

    public Foundation(Servo left, Servo right, long padding) {
        this.left = left;
        this.right = right;

        this.padding = padding;

        initialize();
    }

    public Foundation(Servo left, double leftInitializationPosition, Servo right, double rightInitializationPosition, long padding) {
        this.left = left;
        this.right = right;

        this.padding = padding;

        initialize(leftInitializationPosition, rightInitializationPosition);
    }

    public Foundation(Servo left, double leftMaximumPosition, double leftMinimumPosition, Servo right, double rightMaximumPosition, double rightMinimumPosition) {
        this.left = left;
        this.leftMaximumPosition = leftMaximumPosition;
        this.leftMinimumPosition = leftMinimumPosition;

        this.right = right;
        this.rightMaximumPosition = rightMaximumPosition;
        this.rightMinimumPosition = rightMinimumPosition;

        initialize();
    }

    public Foundation(Servo left, double leftInitializationPosition, double leftMaximumPosition, double leftMinimumPosition, Servo right, double rightInitializationPosition, double rightMaximumPosition, double rightMinimumPosition) {
        this.left = left;
        this.leftMaximumPosition = leftMaximumPosition;
        this.leftMinimumPosition = leftMinimumPosition;

        this.right = right;
        this.rightMaximumPosition = rightMaximumPosition;
        this.rightMinimumPosition = rightMinimumPosition;

        initialize(leftInitializationPosition, rightInitializationPosition);
    }

    public Foundation(Servo left, double leftMaximumPosition, double leftMinimumPosition, Servo right, double rightMaximumPosition, double rightMinimumPosition, long padding) {
        this.left = left;
        this.leftMaximumPosition = leftMaximumPosition;
        this.leftMinimumPosition = leftMinimumPosition;

        this.right = right;
        this.rightMaximumPosition = rightMaximumPosition;
        this.rightMinimumPosition = rightMinimumPosition;

        this.padding = padding;

        initialize();
    }

    public Foundation(Servo left, double leftInitializationPosition, double leftMaximumPosition, double leftMinimumPosition, Servo right, double rightInitializationPosition, double rightMaximumPosition, double rightMinimumPosition, long padding) {
        this.left = left;
        this.leftMaximumPosition = leftMaximumPosition;
        this.leftMinimumPosition = leftMinimumPosition;

        this.right = right;
        this.rightMaximumPosition = rightMaximumPosition;
        this.rightMinimumPosition = rightMinimumPosition;

        this.padding = padding;

        initialize(leftInitializationPosition, rightInitializationPosition);
    }

    public void maximizeLeft() {
        left.setPosition(leftMaximumPosition);
    }

    public void minimizeLeft() {
        left.setPosition(leftMinimumPosition);
    }

    public void maximizeRight() {
        right.setPosition(rightMaximumPosition);
    }

    public void minimizeRight() {
        right.setPosition(rightMinimumPosition);
    }

    public void open() {
        maximizeLeft();
        maximizeRight();

        Utilities.sleep(padding);
    }

    public void close() {
        minimizeLeft();
        minimizeRight();

        Utilities.sleep(padding);
    }

    private void initialize(double leftInitializationPosition, double rightInitializationPosition) {
        left.setDirection(Servo.Direction.FORWARD);
        right.setDirection(Servo.Direction.REVERSE);

        left.setPosition(leftInitializationPosition);
        right.setPosition(rightInitializationPosition);
    }

    private void initialize() {
        initialize(0.5, 0.5);
    }
}
