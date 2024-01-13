// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.TankDrive;
import frc.robot.controllers.TankDriveController;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final DriveTrain driveTrain = new DriveTrain();

  // Joysticks
  private final CommandJoystick leftJoystick = new CommandJoystick(Constants.LEFT_JOYSTICK_USB_ID);
  private final CommandJoystick rightJoystick = new CommandJoystick(Constants.RIGHT_JOYSTICK_USB_ID);
  
  // Commands
  private final TankDrive tankDrive = new TankDrive(driveTrain, new TankDriveController(leftJoystick, rightJoystick));

  // Autonomous
  private final SendableChooser<Command> autonomousChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    configureSubsystems();
    configureAutonomousModes();
  }

  private void configureSubsystems() {
    this.driveTrain.setDefaultCommand(tankDrive);
  }

  private void configureAutonomousModes() {
    this.autonomousChooser.setDefaultOption("Do nothing", new WaitCommand(10.0));
  }
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autonomousChooser.getSelected();
  }
}
