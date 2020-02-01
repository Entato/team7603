package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;

class ColourSensor {
    private static final I2C.Port i2cPort = I2C.Port.kOnboard;
    private static final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    public static String getColour() {
        Color detectedColor = m_colorSensor.getColor();

        /**
         * The sensor returns a raw IR value of the infrared light detected.
         */
        double IR = m_colorSensor.getIR();

        /**
         * Open Smart Dashboard or Shuffleboard to see the color detected by the sensor.
         */
        double red = (detectedColor.red * 3);
        double green = (detectedColor.green * 2);
        double blue = (detectedColor.blue * 4);

        if (red > 1.14 && red < 1.26 && blue > 0.27 && blue < 0.47 && green > 0.92 && green < 1.4) {
            return "Yellow";
        } else if (red > green && red > blue) {
            return "Red";
        } else if (green > red && green > blue) {
            return "Green";
        } else if (blue > red && blue > green) {
            return "Blue";
        }
        
        // int proximity = m_colorSensor.getProximity();

        return "no colour";
    }
}
