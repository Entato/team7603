/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final VictorSPX topShooter;
  private final VictorSPX bottomShooter;

  public Shooter() {
    //Initializes two motors to shoot
    topShooter = new VictorSPX (Constants.upperShooter);
    bottomShooter = new VictorSPX (Constants.lowerShooter);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot() {
    //Turns on the shooter motors
    topShooter.set(-Constants.shooterLimit);
    bottomShooter.set(-Constants.shooterLimit);
  }

  public void intakeHelp() {
    bottomShooter.set(-Constants.shooterLimitIntake);
  }

  public void stop() {
    //Turns off the shooter motors
    topShooter.set(0);
    bottomShooter.set(0);
  }
}
