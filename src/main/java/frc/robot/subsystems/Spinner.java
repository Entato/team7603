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
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;

public class Spinner extends SubsystemBase {
    //Initializes the color sensor, spinner motor and solenoid to lift up the spinner motor/color sensor
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final Victor spinner = new Victor(Constants.spinner);
    private final DoubleSolenoid solenoid = new DoubleSolenoid(0, 3);

    public Spinner() {
    }

    public void spin() {
        //Turns the spinner motor on to spin the control panel
        spinner.set(1);
    }

    public void stopSpin() {
        //Turns the spinner motor off
        spinner.set(0);
    }

    public void upLift() {
        //Lifts up the spinner/color sensor
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void downLift() {
        //Brings the spinner/color sensor down
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    // //Setter for target color
    // public void setTargetColor(String targetColor){
    // this.targetColor = targetColor;
    // }
    public String checkColor() {
        //Uses the color sensor to return a color
        Color detectedColor = m_colorSensor.getColor();
        double IR = m_colorSensor.getIR();
        double red = detectedColor.red;
        double green = detectedColor.green;
        double blue = detectedColor.blue;
        // Displays Colors
        SmartDashboard.putNumber("Red", red);
        SmartDashboard.putNumber("Green", green);
        SmartDashboard.putNumber("Blue", blue);

        // Checks for Yellow
        if (red > Constants.redMinYellow && red < Constants.redMaxYellow && blue > Constants.blueMinYellow && blue < Constants.blueMaxYellow && green > Constants.greenMinYellow && green < Constants.greenMaxYellow) {
            SmartDashboard.putString("Color", "Yellow");
            return "Yellow";
        }
        // Checks for Red
        else if (red > Constants.redMinRed && red < Constants.redMaxRed && blue > Constants.blueMinRed && blue < Constants.blueMaxRed && green > Constants.greenMinRed && green < Constants.greenMaxRed) {
            SmartDashboard.putString("Color", "Red");
            return "Red";
        }
        // Checks for Green
        else if (red > Constants.redMinGreen && red < Constants.redMaxGreen && blue > Constants.blueMinGreen && blue < Constants.blueMaxGreen && green > Constants.greenMinGreen && green < Constants.greenMaxGreen) {
            SmartDashboard.putString("Color", "Green");
            return "Green";
        }
        // Checks for Blue
        else if (red > Constants.redMinBlue && red < Constants.redMaxBlue && blue > Constants.blueMinBlue && blue < Constants.blueMaxBlue && green > Constants.greenMinBlue && green < Constants.greenMaxBlue) {
            return "Blue";
        }
        return null;
    }

    // Method that does 1 full spinner revolution without stopping
    public void spinOnce() {
        int colorChanges = 0;
        // Previous color (Initialized as starting color)
        String oldColor = checkColor();
        // Current color (currentColor being sensed)
        String currentColor = "";

        // One full revolution is 8 color changes
        while (colorChanges < 8) {
            SmartDashboard.putNumber("Color changes:", colorChanges);
            spin();
            currentColor = checkColor();
            // Checks when color changes
            if (!(currentColor.equals(oldColor))) {
                // Adds to revolutions counter
                colorChanges++;
                // Changes current color to the "old color"
                oldColor = currentColor;
            }

        }
    }

    // Method that spins to the selected Color
    public boolean goToColor(String color) {
        String currentColor = checkColor();
        if (currentColor != color) {
            spin();
            return goToColor(color);
        }
        stopSpin();
        return true;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

}
