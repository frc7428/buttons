/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.LowerArmCommand;
import frc.robot.commands.RaiseArmCommand;
import frc.robot.commands.StopArmCommand;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ArmSubsystem mArmSubsystem = new ArmSubsystem();

  private final RaiseArmCommand mRaiseArmCommand = new RaiseArmCommand(mArmSubsystem);
  private final LowerArmCommand mLowerArmCommand = new LowerArmCommand(mArmSubsystem);
  private final StopArmCommand mStopArmCommand = new StopArmCommand(mArmSubsystem);

  private final XboxController mXboxController = new XboxController(Constants.CONTROLLER_USB);
  private final Joystick mJoystick = new Joystick(Constants.JOYSTICK_USB);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // JoystickButton is a button on a Joystick or an XboxController.
    // This does NOT include triggers or D-Pads.
    // These do the exact same thing - one with the Xbox Controller and one with the Joystick
    JoystickButton xboxArmUp = new JoystickButton(mXboxController, Constants.RAISE_ARM_CONTROLLER_BUTTON);
    xboxArmUp.whileHeld(mRaiseArmCommand);
    xboxArmUp.whenReleased(mStopArmCommand);

    JoystickButton joystickArmUp = new JoystickButton(mJoystick, Constants.RAISE_ARM_JOYSTICK_BUTTON);
    joystickArmUp.whileHeld(mRaiseArmCommand);
    joystickArmUp.whenReleased(mStopArmCommand);

    // POVButton is part of a D-Pad (or the nub on a Joystick).
    // POV Angles start with 0 (up) and increase clockwise.
    // Up is 0, Right is 90, Down is 180, and so on.
    // These do the exact same thing - one with the Xbox Controller and one with the Joystick
    POVButton xboxArmDown = new POVButton(mXboxController, 180);
    xboxArmDown.whileHeld(mLowerArmCommand);
    xboxArmDown.whenReleased(mStopArmCommand);
    
    POVButton joystickArmDown = new POVButton(mJoystick, 180);
    joystickArmDown.whileHeld(mLowerArmCommand);
    joystickArmDown.whenReleased(mStopArmCommand);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
