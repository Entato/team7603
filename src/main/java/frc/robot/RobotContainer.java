package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.triggers.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//this file creates the command and subsystem objects then binds them to a button on the controller
//configureButtonBindings() method creates joystickbutton objects to call a command
public class RobotContainer {
  // controller
  private final Joystick controller = new Joystick(Constants.joystickPort);

  // Subsystems
  private final Spinner spinner = new Spinner();
  private final DriveChain driveChain = new DriveChain();
  private final Shooter shooter = new Shooter();
  private final Intake intake = new Intake();
  private final Conveyer conveyer = new Conveyer();
  private final Climber climber = new Climber();

  // Commands
  private final AutonomousCommand autonomousCommand = new AutonomousCommand(shooter, driveChain);
  private final SpinEighthCommand spinEighthCommand = new SpinEighthCommand(spinner);
  //private final SpinOnceCommand spinOnceCommand = new SpinOnceCommand(spinner);
  //private final SpinManualCommand spinManualCommand = new SpinManualCommand(spinner, controller);
  private final DriveCommand driveCommand = new DriveCommand(driveChain, controller);
  private final ShootCommand shootCommand = new ShootCommand(shooter, conveyer);
  private final IntakeCommand intakeCommand = new IntakeCommand(intake, conveyer);
  private final ArmUpCommand armUpCommand = new ArmUpCommand(climber);
  private final LiftCommand liftCommand = new LiftCommand(climber);
  private final LiftSpinnerCommand liftSpinnerCommand = new LiftSpinnerCommand(spinner);
  private final NegDriveCommand negDriveCommand = new NegDriveCommand(driveChain);

  // ignore this for now
  public RobotContainer() {
    configureButtonBindings();
  }

  // method for mapping buttons to call commands
  private void configureButtonBindings() {

    // sets the default command for the drive subsystem to the drive command
    // while the drive subsystem is not being used by another command the drive
    // command will be active
    driveChain.setDefaultCommand(driveCommand);

    // shooter
    // create joystickbutton object with parameters of the joystick and the button
    // ID
    JoystickButton shootButton = new JoystickButton(controller, Constants.buttonA);
    shootButton.whenHeld(shootCommand);

    // spin one revolution
    // JoystickButton spinOnceButton = new JoystickButton(controller, Constants.buttonB);
    // spinOnceButton.whenHeld(spinOnceCommand);

    // spin 1/8 of a revolution
    JoystickButton spinEighthButton = new JoystickButton(controller, Constants.buttonX);
    spinEighthButton.whenHeld(spinEighthCommand);

    // intake
    JoystickButton intakeButton = new JoystickButton(controller, Constants.buttonRB);
    intakeButton.whenHeld(intakeCommand);

    // climber
    POVTrigger climbButton = new POVTrigger(controller, 0);
    climbButton.whenHeld(armUpCommand);

    // lift
    POVTrigger liftButton = new POVTrigger(controller, 180);
    liftButton.whenHeld(liftCommand);

    //liftspinner
    JoystickButton liftSpinnerButton = new JoystickButton(controller, Constants.buttonSTART);
    liftSpinnerButton.whenHeld(liftSpinnerCommand);

    //flip front and back
    JoystickButton flipdriveButton = new JoystickButton(controller, Constants.buttonBACK);
    flipdriveButton.whenPressed(negDriveCommand);
  }

  // used for calling the autonomous command
  public Command getAutonomousCommand() {
    return autonomousCommand;
  }
}
