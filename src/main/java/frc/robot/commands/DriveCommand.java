package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveChain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class DriveCommand extends CommandBase {
  private final DriveChain driveChain;
  private final Joystick controller;

  // commands must take in a parameter of the subsystems they are using so they
  // can access their methods
  public DriveCommand(DriveChain subsystem, Joystick controller) {
    driveChain = subsystem;
    this.controller = controller;
    addRequirements(subsystem);
  }

  // called once and only once when the command is called
  @Override
  public void initialize() {
  }

  // called many times over while the command is active (50hz)
  @Override
  public void execute() {
    // Takes input from the controller to control speed of robot
      driveChain.driveLeft(controller.getRawAxis(Constants.axisLY));
      driveChain.driveRight(controller.getRawAxis(Constants.axisRY));  
  }

  // called once the command ends
  @Override
  public void end(boolean interrupted) {
    // Stops the drive motors
    driveChain.stop();
  }

  // logic to check if the command is finished
  @Override
  public boolean isFinished() {
    return false;
  }
}
