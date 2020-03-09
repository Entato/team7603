/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Spinner;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/**
 * An example command that uses an example subsystem.
 */
public class SpinOnceCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    Spinner spinner;
    private long startTime = 0;
    private long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public SpinOnceCommand(Spinner spinner) {
        this.spinner = spinner;
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        // Turns spinner motors on
        spinner.spin();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Subtracts 1 from the spinner queue
        // Stops the spinner motors
        spinner.minusSpins();
        spinner.stopSpin();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // Timer is updated with the variable 'currentTime'
        currentTime = System.currentTimeMillis();
        // Checks if the amount of time the command has been called for is greater than
        // or equal to the set time of the spinOnce command
        return currentTime - startTime >= Constants.spinOnce;
    }
}
