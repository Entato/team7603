package frc.robot.autonomouscommands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveChain;
import edu.wpi.first.wpilibj2.command.CommandBase;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class DriveBackwardCommand extends CommandBase {
    private final DriveChain driveChain;
    private long startTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public DriveBackwardCommand(DriveChain subsystem) {
        driveChain = subsystem;
        addRequirements(subsystem);
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        driveChain.driveLeft(-1);
        driveChain.driveRight(-1);
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
    }

    // called once the command ends
    @Override
    public void end(boolean interrupted) {
        // Stops the drive motors
        driveChain.stop();
    }

    // logic to check if the command is finished
    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - startTime) > Constants.auto3;
    }
}
