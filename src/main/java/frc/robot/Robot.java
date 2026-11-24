// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;


/**
* The methods in this class are called automatically corresponding to each
* mode, as described in
* the TimedRobot documentation. If you change the name of this class or the
* package after creating
* this project, you must also update the Main.java file in the project.
*/
public class Robot extends TimedRobot {
  /**
  * This function is run when the robot is first started up and should be used
  * for any
  * initialization code.
  */
  public Robot() {
  }
  
  
  private XboxController xboxController = new XboxController(0);
  private Drivetrain driveTrain = new Drivetrain();
  private Intake intake = new Intake(Constants.intakeMotorId, Constants.intakeSpeed);
  public Arm arm = new Arm();
  
  private double startTime;
  
  @Override
  public void robotPeriodic() {
    intake.intakePeriodic();
  }
  
  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }
  
  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    if (time - startTime < Constants.timeToTurn) {

      driveTrain.drive(Constants.driveSpeed);
      intake.rumbleRollers(10, 2);
      
    } else if (time - startTime < Constants.endOfTurn) {

      driveTrain.drive(Constants.turnSpeed + 0.1, Constants.turnSpeed);

    } else if(time - startTime < Constants.timeToTurn2){
      driveTrain.drive(Constants.driveSpeed);
    }else if(time - startTime < Constants.endOfTurn2){
driveTrain.drive(Constants.turnSpeed + 0.1 , Constants.turnSpeed);
    }else if(time - startTime < Constants.timeToTurn3){
      driveTrain.drive(Constants.driveSpeed);
    }else if(time - startTime < Constants.endOfTurn3){
      driveTrain.drive(Constants.turnSpeed + 0.1 , Constants.turnSpeed);
    }else if(time - startTime < Constants.timeToTurn4){
      driveTrain.drive(Constants.driveSpeed);
    }else if(time - startTime < Constants.endOfTurn4){
      driveTrain.drive(Constants.turnSpeed + 0.1 ,Constants.turnSpeed);
    }else if(time - startTime < Constants.timeToTurn5){
driveTrain.drive(Constants.driveSpeed);
    }else if(time - startTime < Constants.endOfTurn5){
driveTrain.drive(Constants.turnSpeed + 0.1 , Constants.turnSpeed);
  }else{

      driveTrain.drive(0, 0);
      intake.stopRollers(); 
    }
    
  }
  
  @Override
  public void teleopInit() {
  }
  
  @Override
  public void teleopPeriodic() {
     if (xboxController.getBButton()){
      arm.rotatearm(1.0);
     } else if(xboxController.getYButton()){
      arm.rotatearm(-1.0);}
      else {
        arm.rotatearm(0);
      }
    if (xboxController.getLeftTriggerAxis() > .2) {
      intake.startRollersIntake();
    } else if (xboxController.getRightTriggerAxis() > .2) {
      intake.startRollersOuttake();
    } else if (xboxController.getLeftBumperButton()) {
      intake.rumbleRollers(2, .2);
    } else {
      intake.stopRollers();
    }
    
    double speed = -xboxController.getRawAxis(4) * 0.3;
    double turn = -xboxController.getRawAxis(1) * 0.5;
    
    if (xboxController.getAButton()){
      speed=speed/2;
      turn=turn/2;
    }
    
    System.out.println("Speed: " + speed + "  Turn: " + turn);
    double left = speed + turn;
    double right = -speed + turn;
    driveTrain.drive(left,right);
    System.out.println("Speed LM1: " + driveTrain.leftMotor1.get());
  }
  
  @Override
  public void disabledInit() {
  }
  
  @Override
  public void disabledPeriodic() {
  }
  
  @Override
  public void testInit() {
  }
  
  @Override
  public void testPeriodic() {
  }
  
  @Override
  public void simulationInit() {
  }
  
  @Override
  public void simulationPeriodic() {
  }
}
