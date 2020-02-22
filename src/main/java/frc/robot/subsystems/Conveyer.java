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

public class Conveyer extends SubsystemBase {
  private final Victor conveyer;

  /**
   * Creates a new ExampleSubsystem.
   */
  public Conveyer() {
    //Initializes the conveyor motor
    conveyer = new Victor(Constants.belt);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shift() {
    //Turns the conveyer motor on to push the ball forward
    conveyer.set(Constants.conveyerLimit);
  }

  public void reverse() {
    //Turns the conveyer in reverse
    conveyer.set(-Constants.conveyerLimit);
  }

  public void stop() {
    //Turns the conveyer motor off
    conveyer.set(0);
  }
}
