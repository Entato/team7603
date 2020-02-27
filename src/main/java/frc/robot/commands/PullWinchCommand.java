/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PullWinchCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Climber arm;

    public PullWinchCommand(Climber arm) {
        this.arm = arm;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // Method for the winch
        arm.pull();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Stops the winch motors (arm motor is already set to 0)
        arm.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}