// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class NavX2Gyro extends AHRS {

  private String  identifier;
  private boolean invertAngle;



  /** 
   * create a new NavX2Gyro
   * 
   * @param identifier a nickname of the device, used in SmartDashboard
   * @param invertAngle controls whether the angles should be inverted (use true to match
   * ADIS16470_IMU in REV-provided MAXSwerve Drive code, false otherwise)
   */
  public NavX2Gyro(String identifier, boolean invertAngle) {

    super();
    this.identifier = identifier;
    this.invertAngle = invertAngle;
    
  } // end constructor NavX2Gyro()



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
