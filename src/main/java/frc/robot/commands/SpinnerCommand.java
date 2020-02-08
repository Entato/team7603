/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Spinner;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

/**
 * An example command that uses an example subsystem.
 */
public class SpinnerCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    Spinner spinner;

    //commands must take in a parameter of the subsystems they are using so they can access their methods
    public SpinnerCommand(Spinner m_shooter) {
        spinner = m_shooter;
    }

    //called once and only once when the command is called
    @Override
    public void initialize() {
    }

    //called many times over while the command is active (50hz)
    @Override
    public void execute() {
        //spinner.sensor();
    }

    //Method that spins the spinner one full rotation
    public void fullSpin(){

    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
