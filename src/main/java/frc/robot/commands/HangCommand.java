package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Hanging;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//command object is used for calling the subsystems methods
//this command sets the drives based on the controllers axis
public class HangCommand extends CommandBase {
    private final Hanging climbing;
    long startTime = 0;
    long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public HangCommand(Hanging climbing) {
        this.climbing = climbing;
        addRequirements(climbing);
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        SmartDashboard.putNumber("Start time: ", startTime);
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        // Motor currently set to reverse
        climbing.retract();
    }

    // called once the command ends
    @Override
    public void end(boolean interrupted) {
        climbing.stop();
    }

    // logic to check if the command is finished
    @Override
    public boolean isFinished() {
        currentTime = System.currentTimeMillis();
        SmartDashboard.putNumber("Current Time: ", currentTime);
        if (currentTime - startTime >= 3000) {
            return true;
        }
        return false;
    }
}
