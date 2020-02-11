package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//create subsystem classes with methods for all the functionality of the subsystem
//eg drivechain will need to be able to set the speed of the drives
public class Hanging extends SubsystemBase {
    private final Victor climbing;

    public Hanging() {
        climbing = new Victor(Constants.winch);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void climb() {
        climbing.set(0.25);
    }

    public void retract() {
        climbing.set(-0.5);
    }

    public void stop() {
        climbing.set(0);
    }
}
