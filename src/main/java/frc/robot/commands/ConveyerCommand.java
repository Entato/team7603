package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Conveyer;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class ConveyerCommand extends CommandBase {
    public final Conveyer conveyer;
    public long startTime = 0;
    public long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public ConveyerCommand(Conveyer conveyer) {
        this.conveyer = conveyer;
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        conveyer.shift();
    }

    // called once the command ends
    @Override
    public void end(boolean interrupted) {
        conveyer.stop();
    }

    // logic to check if the command is finished
    @Override
    public boolean isFinished() {
        currentTime = System.currentTimeMillis();
        return currentTime - startTime >= Constants.intakeConveyer;
    }
}
