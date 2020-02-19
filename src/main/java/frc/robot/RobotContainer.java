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
  private final Spinner spinner = new Spinner();
  private final DriveChain driveChain = new DriveChain();
  private final Shooter shooter = new Shooter();
  private final Intake intake = new Intake();
  private final Conveyer conveyer = new Conveyer();
  private final Climber climber = new Climber();

  //Commands
  private final SpinRevolutionCommand spin1RevCommand = new SpinRevolutionCommand(spinner);
  private final SpecificColorCommand goToColorCommand = new SpecificColorCommand(spinner);
  private final DriveCommand driveCommand = new DriveCommand(driveChain, controller);
  private final ShootCommand shootCommand = new ShootCommand(shooter);
  private final IntakeCommand intakeCommand = new IntakeCommand(intake, conveyer);
  private final ClimbCommand climbCommand = new ClimbCommand(climber);
  private final LiftCommand liftCommand = new LiftCommand(climber);


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
    
    //spin one revolution
    JoystickButton spinButton = new JoystickButton(controller, Constants.buttonB);
    spinButton.whenHeld(spin1RevCommand);

    //go to specific color
    JoystickButton goToColorButton = new JoystickButton(controller, Constants.buttonX);
    goToColorButton.whenHeld(goToColorCommand);

    //intake
    JoystickButton intakeButton = new JoystickButton(controller, Constants.buttonY);
    intakeButton.whenHeld(intakeCommand);

    //climber
    JoystickButton climbButton = new JoystickButton(controller, Constants.buttonLB);
    climbButton.whenHeld(climbCommand);

    //lift
    JoystickButton liftButton = new JoystickButton(Controller, Constants.buttonRB);
    liftButton.whenHeld(liftCommand);
  }

  //used for calling the autonomous command
  public Command getAutonomousCommand() {
    return driveCommand;
  }
}
