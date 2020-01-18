package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

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
     * 0 will be returned.
     * @see Constants#AUTONOMOUS_DURATION
     */
    public static long autonomousTimeRemaining(ElapsedTime period) {
        long remaining = Constants.AUTONOMOUS_DURATION - (long) period.milliseconds();
        if (remaining < 0) {
            remaining = 0;
        }
        return remaining;
    }

    /**
     * Convert degrees into a servo position.
     *
     * @param degrees The angle to be converted.
     * @return <code>degrees</code> converted into a servo position.
     */
    public static double degreesToServoPosition(double degrees) {
        return Math.abs(degrees) / 180.0;
    }

    /**
     * Convert degrees into a goBILDA servo position.
     *
     * @param degrees The angle to be converted.
     * @return <code>degrees</code> converted into a servo position.
     */
    public static double degreesToGoBildaServoPosition(double degrees) {
        return Math.abs(degrees) / 270.0;
    }

    /**
     * Clip a drive power into a safe range.
     *
     * @param power The drive power to clip.
     * @return The clipped drive power.
     */
    public static double clipDrive(double power) {
        return Range.clip(power, Constants.DRIVE_MIN, Constants.DRIVE_MAX);
    }
}
