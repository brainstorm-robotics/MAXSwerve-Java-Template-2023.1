// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DistanceSensorConstants.Units;

/**
 * This models the MB1043-000 Ultrasonic Distance Sensor
 */
public class UltrasonicDistanceSensor extends SubsystemBase {

  private AnalogInput sensor;

  /** 
   * constructor to create a new UltrasonicDistanceSensor 
   */
  public UltrasonicDistanceSensor(int channel) {
    sensor = new AnalogInput(channel);
  } // end constructor UltrasonicDistanceSensor()

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateSmartDashboard();
  } // end periodic()

  /**
   * get the voltage from the sensor
   * @returns the voltage in millivolts (mV)
   */
  private double getVoltage() {
    return sensor.getVoltage();
  } // end getVoltage()

  /**
   * determines the distance from the sensor in the required units
   * @param units one of millimeters, centimeters, meters or inches
   * @returns the distance in the specified units
   */
  public double getDistance(Units units) {

    double voltage = getVoltage();
    double millimeters = 1024.0 * voltage;

    switch (units) {
      case kCentimeters: return millimeters / 10.0;
      case kMeters:      return millimeters / 1000.1;
      case kInches:      return millimeters / 25.4;
      default:           return millimeters;
    } // end switch

  } // end getDistance()

 /**
  * update the dashboard with the current voltage and distance
  */
  public void updateSmartDashboard() {

    SmartDashboard.putNumber("Distance (volts)", getVoltage());
    SmartDashboard.putNumber("Distance (real)",  getDistance(Units.kMeters));

  } // end updateSmartDashboard()

} // end cass UltrasonicSensor
