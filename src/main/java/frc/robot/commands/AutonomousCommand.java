/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * An example command that uses an example subsystem.
 */
public class AutonomousCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    Shooter shooter;
    DriveChain driveChain;
    Boolean endCommand = false;
    private long startTime = 0;
    private long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public AutonomousCommand(Shooter m_shooter, DriveChain m_driveChain) {
        shooter = m_shooter;
        driveChain = m_driveChain;
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        currentTime = System.currentTimeMillis();
        if (currentTime - startTime >= 0 && currentTime - startTime <= Constants.pivotTime1) {
            driveChain.driveLeft(Constants.driveSpeed);
            driveChain.driveRight(-Constants.driveSpeed);

        } else if (currentTime - startTime >= Constants.pivotTime1 && currentTime - startTime <= Constants.driveTime1) {
            driveChain.driveLeft(Constants.driveSpeed);
            driveChain.driveRight(Constants.driveSpeed);

        } else if (currentTime - startTime >= Constants.driveTime1 && currentTime - startTime <= Constants.pivotTime2) {
            driveChain.driveLeft(Constants.driveSpeed);
            driveChain.driveRight(-Constants.driveSpeed);
        } else if (currentTime - startTime >= Constants.pivotTime2 && currentTime - startTime <= Constants.driveTime2) {
            driveChain.driveLeft(Constants.driveSpeed);
            driveChain.driveRight(Constants.driveSpeed);
        }

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        currentTime = System.currentTimeMillis();
        if (currentTime - startTime >= Constants.endTime) {
            return true;
        } else {
            return false;
        }
    }
}