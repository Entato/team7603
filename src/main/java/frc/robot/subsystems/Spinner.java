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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;

public class Spinner extends SubsystemBase {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
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
