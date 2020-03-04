package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//create subsystem classes with methods for all the functionality of the subsystem
//eg drivechain will need to be able to set the speed of the drives
public class DriveChain extends SubsystemBase {
  private VictorSPX LDrive;
  private VictorSPX RDrive;

  public DriveChain() {
    //Initializes two motors to control the left and right side of the robot's mobility component
    LDrive = new VictorSPX (Constants.lDrive);
    RDrive = new VictorSPX (Constants.rDrive);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // sets the left drive of the robot
  public void driveLeft(double speed) {
    //Controls speed of left drive motor through controller input
    LDrive.set(ControlMode.PercentOutput, speed * Constants.driveLimit);
  }

  // sets the right drive of the robot
  public void driveRight(double speed) {
    //Controls speed of right drive motor through controller input
    RDrive.set(ControlMode.PercentOutput, -speed * Constants.driveLimit);
  }

  public void swapLeftRight(){
    VictorSPX temp = LDrive;
    LDrive = RDrive;
    RDrive = temp;
  }
  
  public void stop() {
    //Turns off the drive motors
    LDrive.set(ControlMode.PercentOutput, 0);
    RDrive.set(ControlMode.PercentOutput, 0);
  }
}
