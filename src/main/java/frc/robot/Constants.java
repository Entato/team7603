package frc.robot;

public final class Constants {
    // Speed limits 
    public static final double driveLimit = 0.85;
    public static final double shooterLimit = -0.5;
    public static final double shooterLimitIntake = -0.4;
    public static final double spinnerLimit = 1;
    public static final double spinnerManualLimit = 0.5;
    public static final double armLimit = 1;
    public static final double winchLimit = 1;
    public static final double conveyerLimit = 1;
    public static final double conveyerReverseLimit = -0.5;
    public static final double intakeLimit = 0.5;

    // Joystick
    public static final int joystickPort = 0;
    public static final int controllerPort = 1;

    // VictorSP ports
    public static final int lDrive = 1;
    public static final int rDrive = 3;
    public static final int belt = 8;
    public static final int winch = 2;
    public static final int spinner = 11;
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
    //Drive forward
    public static final long auto1 = 750;
    //Turn left
    public static final long auto2 = 4000;
    //Drive forward
    public static final long auto3 = 10000;
    //Turn left
    public static final long auto4 = 3000;
    //Drive forward
    public static final long auto5 = 4000;
    //Shoots
    public static final long auto6 = 6000;
    //Drives back
    public static final long auto7 = 7000;
    //Stops
    public static final long auto8 = 7500;

    // time limits
    //Using .6 for 3 balls
    public static final double intakeConveyer = 350;
    public static final long spinOnce = 2390;
    public static final long spinEighth = 55;
}