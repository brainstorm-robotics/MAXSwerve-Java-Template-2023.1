// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.Sensor;
import frc.robot.Constants.Gyro;
import frc.robot.Constants.OI;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.InfraredDistanceSensor;
import frc.robot.subsystems.LimitSwitch;
import frc.robot.subsystems.UltrasonicDistanceSensor;

import com.pathplanner.lib.auto.AutoBuilder;



/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems

  private final DriveSubsystem m_robotDrive = new DriveSubsystem();

  // gyros

  private final AHRS          m_gyro  = Gyro.m_gyro;  // replacement gyro
  private final ADXRS450_Gyro m_gyro2 = Gyro.m_gyro2; // redundant/back-up gyro
  
  // analog distance sensors

  private final UltrasonicDistanceSensor m_distance1 = Sensor.m_distance1; // example
  private final InfraredDistanceSensor   m_distance2 = Sensor.m_distance2; // example
  private final LimitSwitch              m_limit1    = Sensor.m_limit1;    // example

  // chooser for Pathplanner

  private final SendableChooser<Command> autoChooser;

  // The driver's controller
  
  XboxController m_driverController = new XboxController(OI.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Configure the button bindings

    configureButtonBindings();

    // Configure default commands
    m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(m_driverController.getLeftY(),  OI.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getLeftX(),  OI.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getRightX(), OI.kDriveDeadband),
                true, true),
            m_robotDrive));

    // calibrate the gyros

    m_gyro .calibrate(); // NavX2 Gyro
    m_gyro2.calibrate(); // FRC Gyro

    // *** Start of code for Pathplanner chooser

      // Build an auto chooser that uses Commands.none() as the default option

      autoChooser = AutoBuilder.buildAutoChooser();

      // Another option that allows you to specify the default auto by its name
      // autoChooser = AutoBuilder.buildAutoChooser("My Default Auto");

      // put the choices on the SmartDashboard
    
      SmartDashboard.putData("Auto Chooser", autoChooser);

    // *** End of code for Pathplanner chooser

  } // end constructor RobotContainer()



  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and
   * then calling passing it to a {@link JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(m_driverController, Button.kR1.value)
        .whileTrue(new RunCommand(
            () -> m_robotDrive.setX(),
            m_robotDrive));

  } // end configureButtonBindings()



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    return autoChooser.getSelected();

  } // end getAutonomousCommand()


  
} // end class RobotContainer
