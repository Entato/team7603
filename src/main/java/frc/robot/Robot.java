/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Calendar;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Initializing specific hardware components
  Victor LeftDrive = new Victor(0);
  Victor RightDrive = new Victor(1);
  Victor shooter1 = new Victor(2);
  Victor shooter2 = new Victor(3);
  Joystick controller = new Joystick(0);
  // DoubleSolenoid kobe = new DoubleSolenoid(0,1);

  // Variables used for shooting and adjusting
  long startTime = 0;
  long deltaTime = 0;
  boolean shooting = false;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    /*
     * if (controller.getRawButton(2)) { kobe.set(DoubleSolenoid.Value.kForward); }
     * 
     * if (controller.getRawButton(3)) { kobe.set(DoubleSolenoid.Value.kOff); } if
     * (controller.getRawButton(5)) { kobe.set(DoubleSolenoid.Value.kReverse); }
     */
    // Getting speed for each drive from joysticks
    LeftDrive.set(controller.getRawAxis(1));
    RightDrive.set(controller.getRawAxis(5));

    // When button is pressed, the shooter motors will run

    /*
    if (controller.getRawButton(1)) {
      shooter1.set(1);
      shooter2.set(-1);
    } else {
      shooter1.set(0);
      shooter2.set(0);
    }
    */

    if (controller.getRawButtonPressed(4)){
      shooting = true;
      startTime = Calendar.getInstance().getTimeInMillis();
    }

    if (shooting) {

      deltaTime = Calendar.getInstance().getTimeInMillis() - startTime;

      SmartDashboard.putNumber("deltaTime", deltaTime);
      SmartDashboard.putBoolean("boolean", deltaTime >= 3000);
      if (deltaTime >= 3000) {

        LeftDrive.set(0);
        RightDrive.set(0);
        shooter1.set(1);
        shooter2.set(-1);
      } else {
        
        LeftDrive.set(-1);
        RightDrive.set(-1);
      }
    }
    
    if (controller.getRawButtonReleased(4)) {
      LeftDrive.set(0);
      RightDrive.set(0);
      shooting = false;
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
