package org.firstinspires.ftc.teamcode.robot.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.teamcode.robot.RobotLinearOpMode;

import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

/**
 * An autonomous which uses vision detection
 */
@Autonomous(name = "Vision Autonomous", group = "Robot Autonomous")
@Disabled
public class VisionAutonomous extends RobotLinearOpMode {
    /**
     * The camera direction
     */
    private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
    /**
     * Whether or not the phone is in portrait mode.
     */
    private static final boolean PHONE_IS_PORTRAIT = false;

    /**
     * Vuforia license key.
     */
    private static final String VUFORIA_KEY = "AagmIFb/////AAABmQeoELJRUUhBnw22N1rfAeURKsi4lO2PBquW4po2++umNgidlnmVALYdHmMXwjhAD9owXoF2zkCbWmBDEStv642zdEddYZGqPjK2pn4bDvhEeSVj4mQs3zR7mB2T94RenHo+qz8zhq4yidyNRZNYF/Y3OUTayx7H6EtYnU6kaOZi30xW6ZzrzzyP/dEG5mHV2pzBHTEu/Qe1g7RcsCG5sFDg0KAagyjxgC6X3z4/EA0tC2554q+o8S+glD7nFidnAF5e2Pti3+gAnwDN6Nl/nRGrsD0JyAVUFFk2Ii0uEorRz31VCD3C4+ib2UHN0QOZwTYgqXQ4JcH5bXJsqn1aDmSeky2smnk7xamtfXkdBm0I";

    /**
     * The amount of millimeters in an inch.
     */
    private static final float mmPerInch = 25.4f;

    /**
     * The height of the center images above the floor.
     */
    private static final float mmTargetHeight = 6.0f * mmPerInch;

    /**
     * Z position of stone target.
     */
    private static final float stoneZ = 2.00f * mmPerInch;

    /**
     * Z position of bridge target.
     */
    private static final float bridgeZ = 6.42f * mmPerInch;

    /**
     * Y position of bridge target.
     */
    private static final float bridgeY = 23.0f * mmPerInch;

    /**
     * X position of bridge target.
     */
    private static final float bridgeX = 5.18f * mmPerInch;

    /**
     * Y rotation of bridge target (degrees).
     */
    private static final float bridgeRotY = 59.0f;

    /**
     * Z rotation of bridge target (degrees).
     */
    private static final float bridgeRotZ = 180.0f;

    /**
     * Length of half the field.
     */
    private static final float halfField = 72.0f * mmPerInch;

    /**
     * Length of fourth the field.
     */
    private static final float quadField = 36.0f * mmPerInch;

    /**
     * Last location matrix.
     */
    private OpenGLMatrix lastLocation = null;
    /**
     * Vuforia object.
     */
    private VuforiaLocalizer vuforia = null;
    /**
     * Whether or not the target is visible.
     */
    private boolean targetVisible = false;

    /**
     * X rotation of the phone.
     */
    private float phoneXRotation = 0.0f;
    /**
     * Y rotation of the phone.
     */
    private float phoneYRotation = 0.0f;
    /**
     * Z rotation of the phone.
     */
    private float phoneZRotation = 0.0f;


    @Override
    public void runOpMode() {/*
        // Initialize the robot using the hardware map.
        robot.init(hardwareMap);

        // Create the Vuforia parameters using the camera ID.
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id",
                hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        // Set the Vuforia license key.
        parameters.vuforiaLicenseKey = VUFORIA_KEY;

        // Set which camera we want to use.
        parameters.cameraName = robot.webcam;

        // Initialize the Vuforia object.
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Load the Skystone targets.
        VuforiaTrackables skystoneTargets = this.vuforia.loadTrackablesFromAsset("Skystone");

        // Stone.
        VuforiaTrackable stoneTarget = skystoneTargets.get(0);
        stoneTarget.setName("Stone");
        // Blue rear bridge.
        VuforiaTrackable blueRearBridge = skystoneTargets.get(1);
        blueRearBridge.setName("Blue Rear Bridge");
        // Red rear bridge.
        VuforiaTrackable redRearBridge = skystoneTargets.get(2);
        redRearBridge.setName("Red Rear Bridge");
        // Red front bridge.
        VuforiaTrackable redFrontBridge = skystoneTargets.get(3);
        redFrontBridge.setName("Red Front Bridge");
        // Blue front bridge.
        VuforiaTrackable blueFrontBridge = skystoneTargets.get(4);
        blueFrontBridge.setName("Blue Front Bridge");
        // Red perimeter 1.
        VuforiaTrackable red1 = skystoneTargets.get(5);
        red1.setName("Red Perimeter 1");
        // Red perimeter 2.
        VuforiaTrackable red2 = skystoneTargets.get(6);
        red2.setName("Red Perimeter 2");
        // Front perimeter 1.
        VuforiaTrackable front1 = skystoneTargets.get(7);
        front1.setName("Front Perimeter 1");
        // Front perimeter 2.
        VuforiaTrackable front2 = skystoneTargets.get(8);
        front2.setName("Front Perimeter 2");
        // Blue perimeter 1.
        VuforiaTrackable blue1 = skystoneTargets.get(9);
        blue1.setName("Blue Perimeter 1");
        // Blue perimeter 2.
        VuforiaTrackable blue2 = skystoneTargets.get(10);
        blue2.setName("Blue Perimeter 2");
        // Rear perimeter 1.
        VuforiaTrackable rear1 = skystoneTargets.get(11);
        rear1.setName("Rear Perimeter 1");
        // Rear perimeter 2.
        VuforiaTrackable rear2 = skystoneTargets.get(12);
        rear2.setName("Rear Perimeter 2");

        // Create list of trackables.
        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>(skystoneTargets);

        // Set the position of the Stone Target. Since it's not fixed in position, assume it's at
        // the field origin. Rotated it to to face forward, and raised it to sit on the ground
        // correctly. This can be used for generic target-centric approach algorithms.
        stoneTarget.setLocation(OpenGLMatrix.translation(0, 0, stoneZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        // Set the position of the bridge support targets with relation to the origin
        // (center of the
        // field).
        blueFrontBridge.setLocation(OpenGLMatrix.translation(-bridgeX, bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, bridgeRotZ)));

        blueRearBridge.setLocation(OpenGLMatrix.translation(-bridgeX, bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, bridgeRotZ)));

        redFrontBridge.setLocation(OpenGLMatrix.translation(-bridgeX, -bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, 0)));

        redRearBridge.setLocation(OpenGLMatrix.translation(bridgeX, -bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, 0)));

        // Set the position of the perimeter targets with relation to the origin (center
        // of the field).
        red1.setLocation(OpenGLMatrix.translation(quadField, -halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));

        red2.setLocation(OpenGLMatrix.translation(-quadField, -halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));

        front1.setLocation(OpenGLMatrix.translation(-halfField, -quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));

        front2.setLocation(OpenGLMatrix.translation(-halfField, quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));

        blue1.setLocation(OpenGLMatrix.translation(-quadField, halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));

        blue2.setLocation(OpenGLMatrix.translation(quadField, halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));

        rear1.setLocation(OpenGLMatrix.translation(halfField, quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        rear2.setLocation(OpenGLMatrix.translation(halfField, -quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        // Create a transformation matrix describing where the phone is on the robot.
        //
        // NOTE: It's very important that you turn *off* your phone's automatic screen
        // rotation
        // option. Lock it into portrait mode for these numbers to work.
        //
        // NOTE: The coordinate frame for the robot looks the same as the field.
        // The robot's forward direction is facing out along X axis, with the LEFT side
        // facing out
        // along the Y axis. Z is UP on the robot. This equates to a bearing angle of 0
        // degrees.
        //
        // The phone starts out lying flat, with the screen facing up and with the
        // physical top of
        // the phone pointing to the left side of the robot.
        //
        // The two examples below assume that the camera is facing forward out the front
        // of the robot.

        // We need to rotate the camera around it's long axis to bring the correct
        // camera forward.
        if (CAMERA_CHOICE == BACK) {
            phoneYRotation = -90;
        } else {
            phoneYRotation = 90;
        }

        // Rotate the phone vertical about the X axis if it's in portrait mode.
        if (PHONE_IS_PORTRAIT) {
            phoneXRotation = 90;
        }

        // Next, translate the camera lens to where it is on the robot.
        // In this example, it is centered (left to right), but forward of the middle of
        // the robot, and above ground level.

        // e.g. camera is 4 inches in front of the robot's center.
        final float CAMERA_X_DISPLACEMENT = 4.0f * mmPerInch;
        // e.g. camera is 8 inches above the ground.
        final float CAMERA_Y_DISPLACEMENT = 8.0f * mmPerInch;
        // e.g. camera is 0 inches to the left of the robot's center, or on its center
        // axis.
        final float CAMERA_Z_DISPLACEMENT = 0.0f;

        OpenGLMatrix robotFromCamera = OpenGLMatrix
                .translation(CAMERA_X_DISPLACEMENT, CAMERA_Y_DISPLACEMENT, CAMERA_Z_DISPLACEMENT).multiplied(Orientation
                        .getRotationMatrix(EXTRINSIC, YZX, DEGREES, phoneYRotation, phoneZRotation, phoneXRotation));

        // Let all of the trackable listeners know where the phone is.
        for (VuforiaTrackable trackable : allTrackables) {
            ((VuforiaTrackableDefaultListener) trackable.getListener()).setPhoneInformation(robotFromCamera,
                    parameters.cameraDirection);
        }

        // NOTE:
        // In this sample, we do not wait for PLAY to be pressed. Target Tracking is started
        // immediately when INIT is pressed. This sequence is used to enable the new remote DS
        // Camera Preview feature to be used with this sample. CONSEQUENTLY do not put any driving
        // commands in this loop. To restore the normal opmode structure, just uncomment the
        // following line.
        // waitForStart();

        // NOTE: To use the remote camera preview:
        // After you hit "init" on the Driver Station, use the options menu to select
        // "Camera Stream." Tap the preview window to receive a fresh image.

        skystoneTargets.activate();
        while (!isStopRequested()) {

            // Check all of the trackable targets to see which one, if any, is visible.
            targetVisible = false;
            for (VuforiaTrackable trackable : allTrackables) {
                if (((VuforiaTrackableDefaultListener) trackable.getListener()).isVisible()) {
                    telemetry.addData("Visible Target", trackable.getName());
                    targetVisible = true;
                    telemetry.addData("Visible Target", "Skystone");

                    // getUpdatedRobotLocation() will return null if no new information is available
                    // since the last time that call was made, or if the trackable is not currently
                    // visible.
                    OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener) trackable.getListener())
                            .getUpdatedRobotLocation();
                    if (robotLocationTransform != null) {
                        lastLocation = robotLocationTransform;
                    }
                    break;
                }
            }

            //driveForward(0.5, 250);

            // Provide feedback as to where the robot is located if we know.
            if (targetVisible) {
                telemetry.addData("Visible Target", "Correct");
                // Express translation of the robot in inches.
                VectorF translation = lastLocation.getTranslation();
                // X, Y, and Z.
                telemetry.addData("Pos (in)", "(%.1f, %.1f, %.1f)", translation.get(0) / mmPerInch,
                        translation.get(1) / mmPerInch, translation.get(2) / mmPerInch);

                // Express the rotation of the robot in degrees.
                Orientation rotation = Orientation.getOrientation(lastLocation, EXTRINSIC, XYZ, DEGREES);
                // Roll, pitch, and yaw.
                telemetry.addData("Rot (deg)", "(%.0f, %.0f, %.0f)", rotation.firstAngle, rotation.secondAngle,
                        rotation.thirdAngle);

                turnIntake(1.0);

                break;
            } else {
                telemetry.addData("Visible Target", "none");
                telemetry.addData("Scanning", "In Process");
            }

            // Drive forward and backward until the robot can see the skystone.
            //driveBackward(0.5, 500);
            //driveForward(0.5, 500);


            telemetry.addData("Loop", "Finished");
            telemetry.update();
        }
        */
    }
}
