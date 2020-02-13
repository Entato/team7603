package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//create subsystem classes with methods for all the functionality of the subsystem
//eg drivechain will need to be able to set the speed of the drives
public class DriveChain extends SubsystemBase {
  private final Victor LDrive;
  private final Victor RDrive;

  public DriveChain() {
    LDrive = new Victor(Constants.lDrive);
    RDrive = new Victor(Constants.rDrive);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // sets the left drive of the robot
  public void driveLeft(double speed) {
    LDrive.set(speed * Constants.driveLimit);
  }

  // sets the right drive of the robot
  public void driveRight(double speed) {
    RDrive.set(speed * Constants.driveLimit * -1);
  }

  public void stop() {
    LDrive.set(0);
    RDrive.set(0);
  }
}
