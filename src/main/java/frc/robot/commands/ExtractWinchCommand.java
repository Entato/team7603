/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Winch;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtractWinchCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Winch winch;

  public ExtractWinchCommand(Winch winch) {
    this.winch = winch;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(winch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Extracts the winch (rope gets shorter)
    winch.extract();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stops the winch motors
    winch.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
