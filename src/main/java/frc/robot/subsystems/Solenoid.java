package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;

  
    
class Solenoid {
  static DoubleSolenoid solenoid = new DoubleSolenoid(0,1);
  static Joystick controller = new Joystick(0);

  public static void solenoid(int buttonY, int buttonA) {
    if (controller.getRawButtonPressed(4)); { solenoid.set(DoubleSolenoid.Value.kForward);}
    if (controller.getRawButton(3)) { solenoid.set(DoubleSolenoid.Value.kOff); } 
    if (controller.getRawButton(1)) { solenoid.set(DoubleSolenoid.Value.kReverse); }
  }
}