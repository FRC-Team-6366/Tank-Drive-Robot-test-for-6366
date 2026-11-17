package frc.robot;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.Timer;

public class Intake {
    double rollerSpeed;
    SparkMax intakeMotor;
    /**
     * @Author Tripp Collins
     * @param motorID This is the intake motors can id
     * @param speed this is the speed that the motor will run at when it is activated
     */
    public Intake(int motorID, double speed) {
        if (speed >1){  // ensures we aren't sending a speed that the motors are unable to handle
            speed = 1;
        }

        if (speed < -1) {
            speed = -1;   // ensures we arent sending a speed that the motors are unable to handle
        }

        this.rollerSpeed = speed;
        this.intakeMotor = new SparkMax(motorID, null);
    }

    /**
     * Starts the rollers to intake balls into the robot at the speed given when making the motor
     * @Author Tripp Collins
     */
    public void startRollersIntake() {
        intakeMotor.set(rollerSpeed); // sets motor speed
    }

    /**
     * Starts the rollers to outtake balls from the robot hopper at the speed given when making the object
     * @Author Tripp Collins
     */
    public void startRollersOuttake() {
        intakeMotor.set(-rollerSpeed); // sets the motor speeds to be reversed
    }

    /**
     * Starts the rollers to intake for a certain amount of seconds
     * @Author Tripp Collins
     * @param seconds the amount of time the rollers should run for
     */
    public void startTimedRollersIntake(double seconds) {
        double startTime = Timer.getFPGATimestamp();   // starting time 
        double currentTime = Timer.getFPGATimestamp();
        while ((currentTime-startTime) < seconds) {  // if we havent completed the time, continue running
            intakeMotor.set(rollerSpeed);
            currentTime = Timer.getFPGATimestamp();
        }
        intakeMotor.set(0); // stops the intake after we have completed the time
    }

    /**
     * Starts the rollers to outake for a certain amount of seconds
     * @Author Tripp Collins
     * @param seconds the amount of time the rollers should run for
     */
    public void startTimedRollersOuttake(double seconds) {
        double startTime = Timer.getFPGATimestamp();       // starting time
        double currentTime = Timer.getFPGATimestamp();
        while ((currentTime-startTime) < seconds) {      // if we havent completed the time, continue running
            intakeMotor.set(-rollerSpeed);
        }
        intakeMotor.set(0); // stops the intake after we have completed the time
    }

    /**
     * Stops the rollers from spining
     * @Author Tripp Collins
     */
    public void stopRollers() {
        intakeMotor.set(0); // sets the speed to 0

    }
}
