/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Winch extends SubsystemBase {
    private final VictorSPX winch;

    public Winch() {
        // Initializes a motor to control the arm and a motor to control the winch
        winch = new VictorSPX (Constants.winch);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void pull() {
        // Turns the winch on to pull the robot up
        winch.set(Constants.winchLimit);
    }

    public void release() {
        // Turns the winch in reverse to release the winch
        winch.set(-Constants.winchLimit);
    }

    public void stop() {
        // Turns the winch motors off
        winch.set(0);
    }
}
