/*----------------------------------------------------------------------------*/
/* Copyright (c) 2008-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

public class POVTrigger extends Button {
    private final GenericHID controller;
    private final int POVNum;

    public POVTrigger(GenericHID controller, int POVNum) {
        this.controller = controller;
        this.POVNum = POVNum;
    }

    @Override
    public boolean get() {
        return controller.getPOV(0) == POVNum;
    }
}