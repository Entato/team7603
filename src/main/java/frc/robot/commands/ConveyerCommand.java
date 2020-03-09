package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Conveyer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class ConveyerCommand extends CommandBase {
    public final Conveyer conveyer;
    public final Shooter bottomShooter;
    public long startTime = 0;
    public long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public ConveyerCommand(Conveyer conveyer, Shooter bottomShooter) {
        this.bottomShooter = bottomShooter;
        this.conveyer = conveyer;
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
        // Conveyer shifts and the bottom shooter motor spins in order to position the
        // balls in a way that prevents the balls from sticking together
        conveyer.shift();
        bottomShooter.intakeHelp();
    }

    // called once the command ends
    @Override
    public void end(boolean interrupted) {
        // Stops the conveyer and bottom shooter motors
        conveyer.stop();
        bottomShooter.stop();
    }

    // logic to check if the command is finished
    @Override
    public boolean isFinished() {
        // Timer is updated with the variable 'currentTime'
        currentTime = System.currentTimeMillis();
        // Checks if the amount of time the command has been called for is greater than
        // or equal to the set time of the intake command
        return currentTime - startTime >= Constants.intakeConveyer;
    }
}
