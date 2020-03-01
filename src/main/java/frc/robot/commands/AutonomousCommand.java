/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

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
        addRequirements(m_shooter);
        addRequirements(m_driveChain);
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        Timer.delay(0.0);
        currentTime = System.currentTimeMillis();
        if (currentTime - startTime >= 0 && currentTime - startTime <= Constants.auto1) {
            //Move forward
            driveChain.driveLeft(0.25);
            driveChain.driveRight(0.25);

        }/* else if (currentTime - startTime >= Constants.auto1 && currentTime - startTime <= Constants.auto2) {
            //Turn left
            shooter.shoot();
            driveChain.driveLeft(0.2);
            driveChain.driveRight(0.2);
        }
            
        } else if (currentTime - startTime >= Constants.auto3 && currentTime - startTime <= Constants.auto4) {
            //Turn left
            driveChain.driveLeft(-1);
            driveChain.driveRight(1);
        } else if (currentTime - startTime >= Constants.auto4 && currentTime - startTime <= Constants.auto5) {
            //Move forward
            driveChain.driveLeft(1);
            driveChain.driveRight(1);
        } else if (currentTime - startTime >= Constants.auto5 && currentTime - startTime <= Constants.auto6) {
            //Shoot
            driveChain.stop();
            shooter.shoot();
        } else if (currentTime - startTime >= Constants.auto6 && currentTime - startTime <= Constants.auto7){
            //Moves back
            driveChain.driveLeft(-1);
            driveChain.driveRight(-1);
            shooter.stop();
        } else if (currentTime - startTime >= Constants.auto7 && currentTime - startTime <= Constants.auto8){
            //Stops driving
            driveChain.stop();
        }
        */
        
        //Move forward

        //Shoot

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
        currentTime = System.currentTimeMillis();
        return (currentTime - startTime) > Constants.auto1;
    }
}