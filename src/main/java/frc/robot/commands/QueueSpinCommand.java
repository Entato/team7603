package frc.robot.commands;

import frc.robot.subsystems.Spinner;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class QueueSpinCommand extends CommandBase {
    public final Spinner spinner;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public QueueSpinCommand(Spinner spinner) {
        this.spinner = spinner;
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        // Adds 1 to the spin queue
        spinner.addSpins();
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
    }

    // called once the command ends
    @Override
    public void end(boolean interrupted) {
    }

    // logic to check if the command is finished
    @Override
    public boolean isFinished() {
        return true;
    }
}
