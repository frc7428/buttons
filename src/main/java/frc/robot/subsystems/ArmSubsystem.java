/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  private final SpeedController mArmMotor = new PWMVictorSPX(Constants.ARM_MOTOR_PWM);
  /**
   * Creates a new ArmSubsystem.
   */
  public ArmSubsystem() {

  }

  public void up() {
    mArmMotor.set(1);
  }

  public void down() {
    mArmMotor.set(-1);
  }

  public void stop() {
    mArmMotor.stopMotor();;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
