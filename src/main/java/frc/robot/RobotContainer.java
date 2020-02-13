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
  private final Spinner spin = new Spinner();
  private final DriveChain driveChain = new DriveChain();
  private final Shooter shooter = new Shooter();
  private final Intake intake = new Intake();
  private final Conveyer conveyer = new Conveyer();

  //Commands
  private final SpinnerCommand spinCommand = new SpinnerCommand(spin, controller);
  private final DriveCommand driveCommand = new DriveCommand(driveChain, controller);
  private final ShootCommand shootCommand = new ShootCommand(shooter);
  private final IntakeCommand intakeCommand = new IntakeCommand(intake, conveyer);
  private final LiftSpinnerCommand liftspinnerCommand = new LiftSpinnerCommand(spin);

  //ignore this for now
  public RobotContainer() {
    configureButtonBindings();
  }

  //method for mapping buttons to call commands
  private void configureButtonBindings() {
    
    //sets the default command for the drive subsystem to the drive command
    //while the drive subsystem is not being used by another command the drive command will be active
    driveChain.setDefaultCommand(driveCommand);

    //shooter
    //create joystickbutton object with parameters of the joystick and the button ID
    JoystickButton shootButton = new JoystickButton(controller, Constants.buttonA);
    shootButton.whenHeld(shootCommand);
    
    JoystickButton buttonSTART = new JoystickButton(controller, Constants.buttonSTART);
    buttonSTART.whenHeld(spinCommand);

    JoystickButton buttonBACK = new JoystickButton(controller, Constants.buttonBACK);
    buttonBACK.whenHeld(spinCommand)
    //intake
    JoystickButton rbButton = new JoystickButton(controller, Constants.buttonRB);
    rbButton.whenHeld(intakeCommand);

    edu.wpi.first.wpilibj.buttons.JoystickButton ybutton = new JoystickButton(controller, Constants.buttonY);
    ybutton.whenPressed(liftspinnerCommand);
  } 

  //used for calling the autonomous command
  public Command getAutonomousCommand() {
    return driveCommand;
  }
}
