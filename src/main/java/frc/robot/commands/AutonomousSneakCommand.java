/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/**
 * An example command that uses an example subsystem.
 */
public class AutonomousSneakCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    Intake intake;
    DriveChain driveChain;
    Boolean endCommand = false;
    private long startTime = 0;
    private long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public AutonomousSneakCommand(Intake intake, DriveChain driveChain) {
        this.intake = intake;
        this.driveChain = driveChain;
        addRequirements(intake);
        addRequirements(driveChain);
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        SmartDashboard.putNumber("Start Time Auto", startTime);
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        currentTime = System.currentTimeMillis();
        SmartDashboard.putNumber("Current Time Auto", currentTime);
        if (currentTime - startTime >= 0 && currentTime - startTime <= Constants.autoSneak1) {
            // Move forward
            driveChain.driveLeft(0.8);
            driveChain.driveRight(0.8);
            intake.intake();
        } 
        
        if (currentTime - startTime >= Constants.autoSneak1 && currentTime - startTime <= Constants.autoSneak2) {
            // Move backwards
            driveChain.driveLeft(-0.8);
            driveChain.driveRight(-0.8);
            intake.stop();
        } 
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        driveChain.stop();
        intake.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        currentTime = System.currentTimeMillis();
        return (currentTime - startTime) > Constants.autoSneak2;
    }
}