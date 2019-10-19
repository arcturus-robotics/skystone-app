package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

/**
 * A collection of various utility methods for our robot.
 */
public class Utilities {
    /**
     * Calculate the remaining time of autonomous.
     *
     * @param period The elapsed time.
     * @return The remaining time of autonomous.
     * If the result of the calculation is less than 0,
     * then this will return 0.
     * @see RobotLinearOpMode#AUTONOMOUS_DURATION
     */
    public static long autonomousTimeRemaining(ElapsedTime period) {
        long remaining = RobotLinearOpMode.AUTONOMOUS_DURATION - (long) period.milliseconds();
        if (remaining < 0) {
            remaining = 0;
        }
        return remaining;
    }
}
