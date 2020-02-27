package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Spinner;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class SpinManualCommand extends CommandBase {
  private final Spinner spinner;
  private final Joystick controller;

  // commands must take in a parameter of the subsystems they are using so they
  // can access their methods
  public SpinManualCommand(Spinner spinner, Joystick controller) {
    this.spinner = spinner;
    this.controller = controller;
    addRequirements(spinner);
  }

  // called once and only once when the command is called
  @Override
  public void initialize() {
  }

  // called many times over while the command is active (50hz)
  @Override
  public void execute() {
    // Takes input from the controller to control spinner
    spinner.spinManual(controller.getRawAxis(Constants.axisLY));
  }

  // called once the command ends
  @Override
  public void end(boolean interrupted) {
    // Stops the drive motors
    spinner.stopSpin();
  }

  // logic to check if the command is finished
  @Override
  public boolean isFinished() {
    return false;
  }
}
