/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Spinner;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class SpinnerCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    Spinner spinner;
    Joystick Controller;
    public SpinnerCommand(Spinner spin, Joystick Controller) {
        spinner = spin;
        this.Controller = Controller;
    }

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
 

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        if (Controller.getRawButton(Constants.buttonBACK)) {
            spinner.spin();
        }
        else if (Controller.getRawButton(Constants.buttonSTART)) {
            spinner.spinL();
        }
    }

    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        spinner.nospin();
    }
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
