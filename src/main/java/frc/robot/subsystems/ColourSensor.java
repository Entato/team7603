/*
package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import frc.robot.*;


public class ColourSensor {
    private static final I2C.Port i2cPort = I2C.Port.kOnboard;
    private static final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    public static void rotateWheel(){

    
    Color detectedColor = m_colorSensor.getColor();
    double IR = m_colorSensor.getIR();

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    /*
    double red = (detectedColor.red*3);
    double green = (detectedColor.green*2);
    double blue = (detectedColor.blue*4);
    double speed = 0.5;
    SmartDashboard.putNumber("Red", detectedColor.red*3);
    SmartDashboard.putNumber("Green", detectedColor.green*2);
    SmartDashboard.putNumber("Blue", detectedColor.blue*4);
    if(red > 1.14 && red <1.29 && blue > 0.27 && blue < 0.47 && green > 0.92 && green < 1.4){
      Robot.color ="Yellow";
      if (counter == 1  && tempcolor != color){
        counter2++;
        tempcolor = color;
      }

    }
    else if (red > green && red > blue){
      color = "Red";
      if (counter == 1  && tempcolor != color){
        counter2++;
        tempcolor = color;
      }
    }
    else if(green > red && green > blue){
      color = "Green";
      if (counter == 1  && tempcolor != color){
        counter2++;
        tempcolor = color;
      }
    }
    else if(blue > red && blue > green){
      color = "Blue";
      if (counter == 1  && tempcolor != color){
        counter2++;
        tempcolor = color;
      }
    }
    
    if (color!= null && counter == 0){
      startcolor = color;
      counter++; 
    }
    SmartDashboard.putString("IR",color);
    int proximity = m_colorSensor.getProximity();
    SmartDashboard.putNumber("Switches", counter2);
    SmartDashboard.putString("startcolor", startcolor);
      startcolor = "stop";
    }
  
    public static String getColor() {
        Color detectedColor = m_colorSensor.getColor();

        /**
         * Open Smart Dashboard or Shuffleboard to see the color detected by the sensor.
         */
        /*
        double red = (detectedColor.red * 3);
        double green = (detectedColor.green * 2);
        double blue = (detectedColor.blue * 4);

        if (red > 0.92 && red < 1.26 && blue > 0.27 && blue < 0.55 && green > 0.92 && green < 1.4) {
            return "Yellow";
        } else if (red > green && red > blue) {
            return "Red";
        } else if (green > red && green > blue) {
            return "Green";
        } else if (blue > red && blue > green) {
            return "Blue";
        }

        return "no colour";
    }
}
*/
