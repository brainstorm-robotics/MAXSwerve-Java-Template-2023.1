// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FRCGyro extends ADXRS450_Gyro {

  private String identifier;
  
  public FRCGyro(String identifier) {
    
    super();
    this.identifier = identifier;

  } // end constructor FRCGyro()

  /**
   * update the SmartDashboard
   */
  public void updateSmartDashboard() {

    SmartDashboard.putNumber(identifier + " heading",  this.getAngle());
    SmartDashboard.putNumber(identifier + " yaw rate", this.getRate());

  } // end updateSmartDashboard()

}
