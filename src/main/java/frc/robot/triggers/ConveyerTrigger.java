/*----------------------------------------------------------------------------*/
/* Copyright (c) 2008-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Intake;

public class ConveyerTrigger extends Trigger{
    private Intake intake;

    public ConveyerTrigger(Intake intake){
        this.intake = intake;
    }

    @Override
    public boolean get(){
        return !intake.checkBall();
    }
}