/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    private final Victor winch;
    private final Victor arm;

    /**
     * Creates a new ExampleSubsystem.
     */
    public Climber() {
        winch = new Victor(Constants.winch);
        arm = new Victor(Constants.arm);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void extend() {
        arm.set(Constants.armLimit);
    }

    public void retract() {
        arm.set(-Constants.armLimit);
    }

    public void pull() {
        winch.set(Constants.winchLimit);
    }

    public void release() {
        winch.set(-Constants.winchLimit);
    }

    public void stop() {
        arm.set(0);
        winch.set(0);
    }
}
