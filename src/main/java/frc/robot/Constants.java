// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public class Constants {
    public static final int controllerID = 0;
    public static final double deadband = 0.1;

    public class Drivetrain {
        public static final int leftMotorID = 0, rightMotorID = 1;
    }

    public class Shooter {
        public static final int motorID = 2;
    }

    public class Hopper {
        public static final int motorID = 3;
    }

    public static class Vision {
        public static final String leftCamID = "Arducam_Left";
        public static final String rightCamID = "Arducam_Right"; 

        public static final int kYellowBallPipeline = 0;

    // Physical measurements (Meters and Degrees)
        public static final double kCameraHeightMeters = 0.4; 
        public static final double kTargetHeightMeters = 0.0; // 0.0 because balls are on the floor
        public static final double kCameraPitchDegrees = -20.0; 
}
}
