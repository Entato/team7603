package frc.robot;

public final class Constants {
    // Speed limits
    public static double driveLimit = 0.8;
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

    // sensor values
    public static final int limitSensor = 9;

    // color values
    public static final double redMinGreen = 0.425;
    public static final double redMaxGreen = 0.438;
    public static final double blueMinGreen = 0.120;
    public static final double blueMaxGreen = 0.139;
    public static final double greenMinGreen = 0.425;
    public static final double greenMaxGreen = 0.438;

    public static final double redMinYellow = 0.415;
    public static final double redMaxYellow = 0.434;
    public static final double blueMinYellow = 0.144;
    public static final double blueMaxYellow = 0.164;
    public static final double greenMinYellow = 0.415;
    public static final double greenMaxYellow = 0.434;

    public static final double redMinRed = 0.404;
    public static final double redMaxRed = 0.422;
    public static final double blueMinRed = 0.162;
    public static final double blueMaxRed = 0.182;
    public static final double greenMinRed = 0.404;
    public static final double greenMaxRed = 0.422;

    public static final double redMinBlue = 0.429;
    public static final double redMaxBlue = 0.449;
    public static final double blueMinBlue = 1.01;
    public static final double blueMaxBlue = 1.210;
    public static final double greenMinBlue = 0.429;
    public static final double greenMaxBlue = 0.449;

    //Autonomous variables
    public static final long driveTime1 = 1000;
    public static final long pivotTime1 = 1500;
    public static final long driveTime2 = 1000;
    public static final long pivotTime2 = 1500;
    public static final long endTime = 3000;
    public static double driveSpeed = 1;



    
    // time limits
    public static final double intakeConveyer = 350;
}