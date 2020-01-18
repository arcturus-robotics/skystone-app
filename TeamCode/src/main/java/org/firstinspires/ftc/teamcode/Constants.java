package org.firstinspires.ftc.teamcode;

public class Constants {
    public static final float DRIVE_MAX = 0.8f;
    public static final float DRIVE_MIN = -0.8f;

    public static final double LEFT_FOUNDATION_INIT = 0.0;
    public static final double LEFT_FOUNDATION_MAX = 0.70;
    public static final double LEFT_FOUNDATION_MIN = 0.25;

    public static final double RIGHT_FOUNDATION_INIT = 0.0;
    public static final double RIGHT_FOUNDATION_MAX = 0.70;
    public static final double RIGHT_FOUNDATION_MIN = 0.25;

    public static final double LEFT_CLAW_INIT = 0.5;
    public static final double LEFT_CLAW_MAX = 0.8;
    public static final double LEFT_CLAW_MIN = 0.2;

    public static final double RIGHT_CLAW_INIT = 0.5;
    public static final double RIGHT_CLAW_MAX = 1.0;
    public static final double RIGHT_CLAW_MIN = 0.0;

    public static final double ARM_INIT = 0.125;
    public static final double ARM_MAX = 0.95;
    public static final double ARM_MIN = 0.125;

    /**
     * The amount of encoder ticks per inch the robot moves.
     */
    public static final double TICKS_PER_INCH = 1.0;

    /**
     * The duration of autonomous (in milliseconds).
     */
    public static final long AUTONOMOUS_DURATION = 30000;

    /**
     * The duration of the initial delay. This delay can prevent our autonomous from clashing with our ally's autonomous.
     */
    public static final long INITIAL_DELAY_DURATION = 0;

    /**
     * Padding between each movement of the motors, servos, etc. (in milliseconds).
     */
    public static final long MOVEMENT_PADDING_DURATION = 30;

    /**
     * The duration to move away from the wall.
     */
    public static final long MOVEMENT_FROM_WALL_DURATION = 200;

    /**
     * The duration to move toward the skybridge.
     */
    public static final long MOVEMENT_TO_SKYBRIDGE_DURATION = 2500;

    /**
     * The duration to move away from the wall, but for taking the scenic route.
     */
    public static final long SCENIC_MOVEMENT_FROM_WALL_DURATION = 1250;

    /**
     * The duration to move toward the skybridge, but for taking the scenic route.
     */
    public static final long SCENIC_MOVEMENT_TO_SKYBRIDGE_DURATION = 2500;
}
