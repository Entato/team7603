package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants;

class Drive {
    static Victor LeftDrive = new Victor(Constants.lDrive);
    static Victor RightDrive = new Victor(Constants.rDrive);

    public static void drive(double lDrive, double rDrive){
        LeftDrive.set(lDrive);
        RightDrive.set(rDrive);
    }
}