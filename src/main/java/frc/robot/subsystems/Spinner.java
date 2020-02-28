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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Spinner extends SubsystemBase {
    //Initializes the color sensor, spinner motor and solenoid to lift up the spinner motor/color sensor
    private final Victor spinner = new Victor(Constants.spinner);
    private final DoubleSolenoid solenoid = new DoubleSolenoid(0, 3);
    private boolean active = false;
    public int spins = 0;

    public Spinner() {
    }

    public void spin() {
        spinner.set(1);
    }

    public void spinManual(double speed) {
        spinner.set(speed * Constants.spinnerManualLimit);
    }

    public int getSpins() {
        return spins;
    }

    public void addSpins() {
        spins++;
        SmartDashboard.putNumber("Spins qd", spins);
    }
    
    public void minusSpins() {
        spins--;
        SmartDashboard.putNumber("Spins after decrease", spins);
    }

    public void stopSpin() {
        //Turns the spinner motor off
        spinner.set(0);
    }

    public boolean getActive(){
        return this.active;
    }
    
    public void upLift() {
        //Lifts up the spinner/color sensor
        solenoid.set(DoubleSolenoid.Value.kForward);
        this.active = true;
    }

    public void downLift() {
        //Brings the spinner/color sensor down
        solenoid.set(DoubleSolenoid.Value.kReverse);
        this.active = false;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

}
