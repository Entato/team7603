/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/**
 * An example command that uses an example subsystem.
 */
public class AutonomousCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    Shooter shooter;
    DriveChain driveChain;
    Conveyer conveyer;
    Boolean endCommand = false;
    private long startTime = 0;
    private long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public AutonomousCommand(Shooter shooter, DriveChain driveChain, Conveyer conveyer) {
        this.shooter = shooter;
        this.driveChain = driveChain;
        this.conveyer = conveyer;
        addRequirements(shooter);
        addRequirements(driveChain);
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        // Starts a timer
        startTime = System.currentTimeMillis();
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        // Timer is updated with the variable 'currentTime'
        currentTime = System.currentTimeMillis();
        // Within the specified amount of time, methods will be called to complete
        // specific tasks
        if (currentTime - startTime >= 0 && currentTime - startTime <= Constants.auto1) {
            // Move back
            driveChain.driveLeft(0.4);
            driveChain.driveRight(0.4);
        }
        if (currentTime - startTime >= Constants.auto1 && currentTime - startTime <= Constants.auto2) {
            // Shoot
            driveChain.stop();
            conveyer.shift();
            shooter.shoot();
        }
        if (currentTime - startTime >= Constants.auto2 && currentTime - startTime <= Constants.auto3) {
            // Moves forward
            driveChain.driveLeft(-0.4);
            driveChain.driveRight(-0.4);
            shooter.stop();
            conveyer.stop();
        }
        if (currentTime - startTime >= Constants.auto3 && currentTime - startTime <= Constants.auto4) {
            // Stops driving
            driveChain.stop();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        driveChain.stop();
        shooter.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // Timer is updated with the variable 'currentTime'
        currentTime = System.currentTimeMillis();
        // Checks if the amount of time the command has been called for is greater than
        // or equal to the set time of the autonomous command (auto4)
        return (currentTime - startTime) > Constants.auto4;
    }
}