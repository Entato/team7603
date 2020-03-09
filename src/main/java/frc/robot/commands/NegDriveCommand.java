package frc.robot.commands;

import frc.robot.subsystems.DriveChain;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class NegDriveCommand extends CommandBase {
  // commands must take in a parameter of the subsystems they are using so they
  // can access their methods
  private DriveChain driveChain;

  public NegDriveCommand(DriveChain driveChain) {
    this.driveChain = driveChain;
  }

  // called once and only once when the command is called
  @Override
  public void initialize() {
    // Flips the left and right drive which allows the robot to be driven
    // forward/backwards
    driveChain.swapLeftRight();
  }

  // called many times over while the command is active (50hz)
  @Override
  public void execute() {
  }

  // called once the command ends
  @Override
  public void end(boolean interrupted) {
  }

  // logic to check if the command is finished
  @Override
  public boolean isFinished() {
    return true;
  }
}
