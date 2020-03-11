/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

public class Intake extends SubsystemBase {
    private final TalonSRX intake;
    private DigitalInput limit = new DigitalInput(Constants.limitSensor);

    public Intake() {
        //Initializes the intake motor
        intake = new TalonSRX(Constants.intake);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void intake() {
        //Turns the motor on to intake the ball
        intake.set(ControlMode.PercentOutput, Constants.intakeLimit);
    }

    public void reverse(){
        intake.set(ControlMode.PercentOutput, -Constants.intakeLimit);
    }

    public void stop() {
        //Turns the motor off
        intake.set(ControlMode.PercentOutput, 0);
    }

    public boolean checkBall() {
        //Checks if a ball triggers the sensor and returns a boolean value
        //Currently returns false if sensor is pressed
        return limit.get();
    }
}
