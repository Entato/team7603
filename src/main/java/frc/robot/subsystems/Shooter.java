package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants;

class Shooter {
    static Victor shooter1 = new Victor(Constants.shooter1);
    static Victor shooter2 = new Victor(Constants.shooter1);

    public static void shoot(){
        shooter1.set(1);
        shooter2.set(-1);
    }

    public static void stop(){
        shooter1.set(0);
        shooter2.set(0);
    }

    public static void align(){
        
    }
}