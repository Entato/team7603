/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Conveyer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class IntakeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake intake;
  private final Conveyer conveyer;
  private boolean intaking = false;
  private long startTime = 0;
  private long currentTime = 0;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeCommand(Intake intake, Conveyer conveyer) {
    this.intake = intake;
    this.conveyer = conveyer;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
    addRequirements(conveyer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Intake motor is always on
    intake.intake();    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(intake.checkBall() && intaking == false) {
      intaking = true;
      //Initializes start time for the conveyer once a ball goes through
      startTime = System.currentTimeMillis();
    }
    if(intaking){
      currentTime = System.currentTimeMillis();
      conveyer.shift();
      if(currentTime - startTime == 1000) {
        intaking = false;
        conveyer.stop();
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop();
    conveyer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
