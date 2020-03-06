/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

    public void extract() {
        // Turns the winch on to pull the robot up
        winch.set(ControlMode.PercentOutput, Constants.winchLimit);
        SmartDashboard.putNumber("Pull", winch.getMotorOutputVoltage());
    }

    public void release() {
        // Turns the winch in reverse to release the winch
        winch.set(ControlMode.PercentOutput, -Constants.winchLimit);
        SmartDashboard.putNumber("Release", winch.getMotorOutputVoltage());

    }

    public void stop() {
        // Turns the winch motors off
        winch.set(ControlMode.PercentOutput, 0);
    }
}
