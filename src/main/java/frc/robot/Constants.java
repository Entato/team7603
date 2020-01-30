package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
    public static final double speedLimit = 0.6;
    
    //Joystick
    public static final Joystick controller = new Joystick(0);

    //Solenoid
    public static final DoubleSolenoid solenoid = new DoubleSolenoid(0,1);

    //VictorSP ports
    public static final int lDrive = 0;
    public static final int rDrive = 1;
    public static final int shooter1 = 2;
    public static final int shooter2 = 3;
    public static final int spinner = 4;
    public static final int intake = 5;
    public static final int belt = 6;
    public static final int winch = 7;
    public static final int scissorLift = 8;

    //controller button values
    public static final int buttonA = 1;
    public static final int buttonB = 2;
    public static final int buttonX = 3;
    public static final int buttonY = 4;
    public static final int buttonLB = 5;
    public static final int buttonRB = 6;
    public static final int buttonBACK = 7;
    public static final int buttonSTART = 8;
    public static final int buttonLJ = 9;
    public static final int buttonRJ = 10;

    //controller axis values
    public static final int axisLX = 0;
    public static final int axisLY = 1;
    public static final int LTrigger = 2;
    public static final int RTrigger = 3;
    public static final int axisRX = 4;
    public static final int axisRY = 5;
}