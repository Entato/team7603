package frc.robot;

public final class Constants {
    // Speed limits
    public static final double driveLimit = 0.8;
    public static final double shooterLimit = -0.5;
    public static final double spinnerLimit = 1;
    public static final double armLimit = 1;
    public static final double winchLimit = 1;
    public static final double conveyerLimit = 1;
    public static final double intakeLimit = 0.35;

    // Joystick
    public static final int joystickPort = 0;

    // VictorSP ports
    public static final int lDrive = 1;
    public static final int rDrive = 3;
    public static final int belt = 8;
    public static final int winch = 4;
    public static final int spinner = 2;
    public static final int upperShooter = 6;
    public static final int lowerShooter = 5;
    public static final int intake = 7;
    public static final int arm = 0;

    // controller button values
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

    // controller axis values
    public static final int axisLX = 0;
    public static final int axisLY = 1;
    public static final int LTrigger = 2;
    public static final int RTrigger = 3;
    public static final int axisRX = 4;
    public static final int axisRY = 5;

    //pov button values
    public static final int POVup = 0;
    public static final int POVdown = 180;
    public static final int POVleft = 270;
    public static final int POVright = 90;
    public static final int POVupright = 45;
    public static final int POVupleft = 315;
    public static final int POVdownright = 135;
    public static final int POVdownleft = 225;

    // sensor values
    public static final int limitSensor = 9;

    //Autonomous variables
    public static final long driveTime1 = 1000;
    public static final long pivotTime1 = 1500;
    public static final long driveTime2 = 1000;
    public static final long pivotTime2 = 1500;
    public static final long endTime = 3000;
    public static double driveSpeed = 1;
    
    // time limits
    public static final double intakeConveyer = 350;
    public static final long spinOnce = 0;
    public static final long spinEighth = 0;
}