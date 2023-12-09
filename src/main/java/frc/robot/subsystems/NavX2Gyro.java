// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.GyroConstants;

public class NavX2Gyro extends AHRS {

  private String identifier;

  /** Creates a new NavX2Gyro. */
  public NavX2Gyro(String identifier) {

    super();
    this.identifier = identifier;
    
  } // end constructor NavX2Gyro()

  public void updateSmartDashboard() {
    SmartDashboard.putNumber(identifier + "Roll",     GyroConstants.m_gyro.getRoll());  /* when + roll  to  left */
    SmartDashboard.putNumber(identifier + "Pitch",    GyroConstants.m_gyro.getPitch()); /* when + tilt backwards */
    SmartDashboard.putNumber(identifier + "Yaw",      GyroConstants.m_gyro.getYaw());   /* when + turn clockwise */

    SmartDashboard.putNumber(identifier + "Heading",  GyroConstants.m_gyro.getAngle());
    SmartDashboard.putNumber(identifier + "Yaw Rate", GyroConstants.m_gyro.getRate());

  }
}
