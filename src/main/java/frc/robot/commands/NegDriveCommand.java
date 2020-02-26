package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveChain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class NegDriveCommand extends CommandBase {
  // commands must take in a parameter of the subsystems they are using so they
  // can access their methods
  public NegDriveCommand() {
  }

  // called once and only once when the command is called
  @Override
  public void initialize() {
    int temp = Constants.rDrive;
    Constants.rDrive = Constants.lDrive;
    Constants.lDrive = temp;
  }

  // called many times over while the command is active (50hz)
  @Override
  public void execute() {
  }

  // called once the command ends
  @Override
  public void end(boolean interrupted) {
    // Stops the drive motors
  }

  // logic to check if the command is finished
  @Override
  public boolean isFinished() {
    return true;
  }
}
