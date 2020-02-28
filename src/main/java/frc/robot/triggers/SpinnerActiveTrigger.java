/*----------------------------------------------------------------------------*/
/* Copyright (c) 2008-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Spinner;

public class SpinnerActiveTrigger extends Trigger{
    private Spinner spinner;

    public SpinnerActiveTrigger(Spinner spinner){
        this.spinner = spinner;
    }

    @Override
    public boolean get(){
        return spinner.getActive();
    }
}