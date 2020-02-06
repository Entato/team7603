package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  //initialise every subystem and command objects at the top

  //controller
  private final Joystick controller = new Joystick(Constants.joystickPort);

  //Subsystems
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveChain driveChain = new DriveChain();

  //Commands
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final DriveCommand driveCommand = new DriveCommand(driveChain, controller);

  //ignore this for now
  public RobotContainer() {
    configureButtonBindings();
  }

  //method for mapping buttons
  private void configureButtonBindings() {

    //create joystickbutton object with parameters of the joystick and the button ID
    JoystickButton exampleButton = new JoystickButton(controller, 1);
    //use joystickbutton, whenHeld(), whenPressed(), and whenReleased() methods to add commands
    exampleButton.whenHeld(m_autoCommand);

    JoystickButton lAxis = new JoystickButton(controller, Constants.axisLY);
    lAxis.whenHeld(driveCommand);

    JoystickButton rAxis = new JoystickButton(controller, Constants.axisRY);
    rAxis.whenHeld(driveCommand);
  }

  //used for calling the autonomous command
  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
