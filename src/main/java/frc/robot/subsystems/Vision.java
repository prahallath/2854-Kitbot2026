package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Vision extends SubsystemBase {
    // Creating the "handles" for your two Arducams
    private final PhotonCamera leftCamera = new PhotonCamera(Constants.Vision.leftCamID);
    private final PhotonCamera rightCamera = new PhotonCamera(Constants.Vision.rightCamID);

    public Vision() {
        // Ensure both cameras are looking for yellow balls (Pipeline 0)
        leftCamera.setPipelineIndex(0);
        rightCamera.setPipelineIndex(0);
    }

    /**
    Finds the best ball from a specific camera
     */
    public PhotonTrackedTarget getBestBall(String cameraID) {
        PhotonPipelineResult result;
        
        if (cameraID.equals(Constants.Vision.leftCamID)) {
            result = leftCamera.getLatestResult();
        } else {
            result = rightCamera.getLatestResult();
        }

        if (result.hasTargets()) {
            return result.getBestTarget();
        }
        return null;
    }

    /**
     * Helper to get the angle to the ball from the left camera
     */
    public double getLeftBallYaw() {
        PhotonTrackedTarget target = getBestBall(Constants.Vision.leftCamID);
        return (target != null) ? target.getYaw() : 0.0;
    }
    public double getRightBallYaw() {
    PhotonTrackedTarget target = getBestBall(Constants.Vision.rightCamID);
    return (target != null) ? target.getYaw() : 0.0;
}

 
public void periodic() {
    SmartDashboard.putBoolean("Left Cam Has Ball", leftCamera.getLatestResult().hasTargets());
    SmartDashboard.putNumber("Left Ball Angle", getLeftBallYaw());
    
    SmartDashboard.putBoolean("Right Cam Has Ball", rightCamera.getLatestResult().hasTargets());
    SmartDashboard.putNumber("Right Ball Angle", getRightBallYaw());
}
    
}