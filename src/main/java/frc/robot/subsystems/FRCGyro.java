// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class FRCGyro extends ADXRS450_Gyro {

  private String identifier;
  private boolean invertAngle;


/** 
   * create a new FRCGyro
   * 
   * @param Identifier a nickname of the device, used in SmartDashboard
   * @param invertAngle controls whether the angles should be inverted (use true to match 
   * ADIS16470_IMU in REV-provided MAXSwerve Drive code, false otherwise)
   */ 
public FRCGyro(String identifier, boolean invertAngle) {
    
    super();
    this.identifier  = identifier;
    this.invertAngle = invertAngle;

  } // end constructor FRCGyro()



  /**
   * returns the angle, may be negated here depending on whether angles are CW or CCW positive
   */
  public double getAngle() {

    if (invertAngle) {
      return -super.getAngle();
    } // end if

    return super.getAngle();

  } // end getAngle()



  /*
   * returns the rate, may be negated here depending on whether rates are CW or CCW positive
   */
  public double getRate() {

    if (invertAngle) {
      return -super.getRate();
    } // end if
    
    return super.getRate();

  } // end getRate()
  
  
  
  /**
   * update the SmartDashboard
   */
  public void updateSmartDashboard() {

    SmartDashboard.putNumber(identifier + " heading",  this.getAngle());
    SmartDashboard.putNumber(identifier + " yaw rate", this.getRate());

  } // end updateSmartDashboard()

}
