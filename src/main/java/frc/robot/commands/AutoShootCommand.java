/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.Constants;
import frc.robot.subsystems.Conveyer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class AutoShootCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Shooter shooter;
  private final Conveyer conveyer;
  private long startTime = 0;

  public AutoShootCommand(Shooter shooter, Conveyer conveyer) {
    this.shooter = shooter;
    this.conveyer = conveyer;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    addRequirements(conveyer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
    conveyer.shift();
    shooter.shoot();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
    conveyer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - startTime) > Constants.auto2;
  }
}
