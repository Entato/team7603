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

public class Shooter extends SubsystemBase {
  private final Victor topShooter;
  private final Victor bottomShooter;

  /**
   * Creates a new ExampleSubsystem.
   */
  public Shooter() {
    topShooter = new Victor(Constants.shooter1);
    bottomShooter = new Victor(Constants.shooter2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot() {
    topShooter.set(1);
    bottomShooter.set(-1);
  }

  public void stop() {
    topShooter.set(0);
    bottomShooter.set(0);
  }
}
