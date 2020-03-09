/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    private final VictorSPX arm;

    public Arm() {
        //Initializes a motor to control the arm and a motor to control the winch
        arm = new VictorSPX (Constants.arm);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void extend() {
        //Turns the motor on to extend the arm
        arm.set(ControlMode.PercentOutput, Constants.armLimit);
    }

    public void retract() {
        //Turns the motor in reverse to pull the arm back
        arm.set(ControlMode.PercentOutput, -Constants.armLimit);
    }

    public void stop() {
        //Turns the winch and arm motors off
        arm.set(ControlMode.PercentOutput, 0);
    }
}
