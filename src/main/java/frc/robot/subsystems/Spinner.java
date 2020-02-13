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

public class Spinner extends SubsystemBase {
    private final Victor spinner = new Victor(Constants.spinner);
    private final DoubleSolenoid lift = new DoubleSolenoid(0, 1);

    /**
     * Creates a new ExampleSubsystem.
     */
    
    public Spinner() {
    }
    public void uplift() {
        lift.set(DoubleSolenoid.Value.kForward);
    }
    public void downlift() {
        lift.set(DoubleSolenoid.Value.kReverse);
    }
    public void spin() {
        spinner.set(Constants.spinnerLimit);
    }
    public void spinL() {
        spinner.set(-Constants.spinnerLimit);
    }
    public void nospin(){
        spinner.set(0);
    }
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }


}
