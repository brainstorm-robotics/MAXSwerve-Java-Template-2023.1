// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class NavX2Gyro extends AHRS {

  private String identifier;



  /** 
   * create a new NavX2Gyro
  */
  public NavX2Gyro(String identifier) {

    super();
    this.identifier = identifier;
    
  } // end constructor NavX2Gyro()



  public void updateSmartDashboard() {

    SmartDashboard.putNumber(identifier + "Roll",  this.getRoll());  /* when + roll  to  left */
    SmartDashboard.putNumber(identifier + "Pitch", this.getPitch()); /* when + tilt backwards */
    SmartDashboard.putNumber(identifier + "Yaw",   this.getYaw());   /* when + turn clockwise */

    SmartDashboard.putNumber(identifier + " ΔX", this.getDisplacementX()); // relative to starting field position
    SmartDashboard.putNumber(identifier + " ΔY", this.getDisplacementY()); // relative to starting field position
    SmartDashboard.putNumber(identifier + " ΔZ", this.getDisplacementZ()); // relative to starting field position

    SmartDashboard.putNumber(identifier + "Heading",  this.getAngle());
    SmartDashboard.putNumber(identifier + "Yaw Rate", this.getRate());

  } // end updateSmartDashboard()


  
} // end class NavX2Gyro
