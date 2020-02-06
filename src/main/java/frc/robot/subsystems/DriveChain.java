/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//create subsystem classes with methods for all the functionality of the subsystem
public class DriveChain extends SubsystemBase {
  private final Victor LDrive = new Victor(Constants.lDrive);
  private final Victor RDrive = new Victor(Constants.rDrive);

  public DriveChain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //sets the left drive of the robot
  public void driveLeft(double speed){
    LDrive.set(speed);
  }

  //sets the right drive of the robot
  public void driveRight(double speed){
    RDrive.set(speed);
  }

  public void stop(){
    LDrive.set(0);
    RDrive.set(0);
  }
}
