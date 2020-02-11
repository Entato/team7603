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
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;

public class Spinner extends SubsystemBase {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final Victor spinner = new Victor(Constants.spinner);

    /**
     * Creates a new ExampleSubsystem.
     */
    boolean nullChecker = true;
    int switches = 0;
    String startColor = "null";
    String tempColor = "null";
    String color = "null";
    String spinning = "true";

    public Spinner() {
    }
    public void spin(){
        spinner.set(1);
    }
    public void stopSpin(){
        spinner.set(0);
    }
    public void sensor() {
        spin();
        Color detectedColor = m_colorSensor.getColor();
        double IR = m_colorSensor.getIR();
        double red = (detectedColor.red * 3);
        double green = (detectedColor.green * 2);
        double blue = (detectedColor.blue * 4);
        double speed = 0.5;
        SmartDashboard.putNumber("Red", detectedColor.red * 3);
        SmartDashboard.putNumber("Green", detectedColor.green * 2);
        SmartDashboard.putNumber("Blue", detectedColor.blue * 4);
        if (red > 1.14 && red < 1.29 && blue > 0.27 && blue < 0.47 && green > 0.92 && green < 1.4) {
            color = "Yellow";
            if (nullChecker == true && tempColor != color) {
                switches++;
                tempColor = color;
            }

        } else if (red > green && red > blue) {
            color = "Red";
            if (nullChecker == true && tempColor != color) {
                switches++;
                tempColor = color;
            }
        } else if (green > red && green > blue) {
            color = "Green";
            if (nullChecker == true && tempColor != color) {
                switches++;
                tempColor = color;
            }
        } else if (blue > red && blue > green) {
            color = "Blue";
            if (nullChecker == true && tempColor != color) {
                switches++;
                tempColor = color;
            }
        }

        if (color != null && nullChecker == false) {
            startColor = color;
            nullChecker = true;
        }

        SmartDashboard.putString("Current_Color", color);
        int proximity = m_colorSensor.getProximity();
        SmartDashboard.putNumber("Switches", switches);
        SmartDashboard.putString("Start_color", startColor);
        SmartDashboard.putString("Spinning", spinning);
        if (color == "Red") {
            speed = (-0.4);// brake function
            spinning = "False";
            stopSpin();
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }


}
