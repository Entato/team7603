package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//this file creates the command and subsystem objects then binds them to a button on the controller
//configureButtonBindings() method creates joystickbutton objects to call a command
public class RobotContainer {
  //controller
  private final Joystick controller = new Joystick(Constants.joystickPort);

  //Subsystems
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveChain driveChain = new DriveChain();
  private final Shooter shooter = new Shooter();

  //Commands
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final DriveCommand driveCommand = new DriveCommand(driveChain, controller);
  private final ShootCommand shootCommand = new ShootCommand(shooter);

  //ignore this for now
  public RobotContainer() {
    configureButtonBindings();
  }

  //method for mapping buttons to call commands
  private void configureButtonBindings() {

    //example button and command
    //create joystickbutton object with parameters of the joystick and the button ID
    JoystickButton exampleButton = new JoystickButton(controller, 1);
    //use joystickbutton, whenHeld(), whenPressed(), and whenReleased() methods to add commands
    exampleButton.whenHeld(m_autoCommand);

    //drives
    JoystickButton lAxis = new JoystickButton(controller, Constants.axisLY);
    JoystickButton rAxis = new JoystickButton(controller, Constants.axisRY);
    //or statement to check if either the lAxis or rAxis is active
    rAxis.or(lAxis).whenActive(driveCommand);

    //shooter
    JoystickButton shootButton = new JoystickButton(controller, Constants.buttonA);
    shootButton.whenHeld(shootCommand);
  }

  //used for calling the autonomous command
  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
