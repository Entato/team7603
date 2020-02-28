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
  private final Joystick controller = new Joystick(Constants.controllerPort);
  private final Joystick joystick = new Joystick(Constants.joystickPort);


  // Subsystems
  private final Spinner spinner = new Spinner();
  private final DriveChain driveChain = new DriveChain();
  private final Shooter shooter = new Shooter();
  private final Intake intake = new Intake();
  private final Conveyer conveyer = new Conveyer();
  private final Arm arm = new Arm();
  private final Winch winch = new Winch();

  // Commands
  private final AutonomousCommand autonomousCommand = new AutonomousCommand(shooter, driveChain);
  private final SpinEighthCommand spinEighthCommand = new SpinEighthCommand(spinner);
  private final SpinOnceCommand spinOnceCommand = new SpinOnceCommand(spinner);
  private final SpinManualCommand spinManualCommand = new SpinManualCommand(spinner, joystick);
  private final DriveCommand driveCommand = new DriveCommand(driveChain, controller);
  private final ShootCommand shootCommand = new ShootCommand(shooter, conveyer);
  private final IntakeCommand intakeCommand = new IntakeCommand(intake);
  private final ConveyerCommand conveyerCommand = new ConveyerCommand(conveyer, shooter);
  private final ArmDownCommand armDownCommand = new ArmDownCommand(arm);
  private final ArmUpCommand armUpCommand = new ArmUpCommand(arm);
  private final ExtractWinchCommand extractWinchCommand = new ExtractWinchCommand(winch);
  private final ReleaseWinchCommand releaseWinchCommand = new ReleaseWinchCommand(winch);
  private final LiftSpinnerCommand liftSpinnerCommand = new LiftSpinnerCommand(spinner);
  private final NegDriveCommand negDriveCommand = new NegDriveCommand(driveChain);
  private final ReverseIntakeCommand reverseIntakeCommand = new ReverseIntakeCommand(intake, conveyer);
  private final QueueSpinCommand queueSpinCommand = new QueueSpinCommand(spinner);

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
    JoystickButton shootButton = new JoystickButton(controller, Constants.buttonLB);
    shootButton.whenHeld(shootCommand);

    // queues spin one revolution
    JoystickButton queueSpinButton = new JoystickButton(controller, Constants.buttonB);
    queueSpinButton.whenPressed(queueSpinCommand);

    // actually spins it depending on whether the queue has at least 1 spin queued up
    SpinsTrigger spinOnce = new SpinsTrigger(spinner);
    spinOnce.whileActiveContinuous(spinOnceCommand);

    // spin 1/8th of a revolution
    JoystickButton spinEighthButton = new JoystickButton(controller, Constants.buttonA);
    spinEighthButton.whenPressed(spinEighthCommand);

    // spin manually left
    AxisTrigger spinManualButton = new AxisTrigger(joystick, 0);
    spinManualButton.whenHeld(spinManualCommand);

    // intake
    JoystickButton intakeButton = new JoystickButton(controller, Constants.buttonRB);
    intakeButton.whenHeld(intakeCommand);

    // conveyer
    ConveyerTrigger conveyerMove = new ConveyerTrigger(intake);
    conveyerMove.whenPressed(conveyerCommand);

    // arm down
    JoystickButton armDownButton = new JoystickButton(joystick, 3);
    armDownButton.whenHeld(armDownCommand);

    // arm up
    JoystickButton armUpButton = new JoystickButton(joystick, 4);
    armUpButton.whenHeld(armUpCommand);

    // lift robot / extract winch
    JoystickButton liftButton = new JoystickButton(joystick, 11);
    liftButton.whenHeld(extractWinchCommand);

    // release winch
    JoystickButton releaseWinchButton = new JoystickButton(joystick, 12);
    releaseWinchButton.whenHeld(releaseWinchCommand);

    // liftspinner
    JoystickButton liftSpinnerButton = new JoystickButton(joystick, 7);
    liftSpinnerButton.whenHeld(liftSpinnerCommand);

    // flip front and back
    JoystickButton flipdriveButton = new JoystickButton(controller, Constants.buttonBACK);
    flipdriveButton.whenPressed(negDriveCommand);

    // reverse intake
    JoystickButton reverseIntakeButton = new JoystickButton(joystick, 8);
    reverseIntakeButton.whenHeld(reverseIntakeCommand);

  }

  // used for calling the autonomous command
  public Command getAutonomousCommand() {
    return autonomousCommand;
  }
}
