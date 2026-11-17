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
        intakeMotor.set(-rollerSpeed);
    }

    /**
     * Starts the rollers to intake for a certain amount of seconds
     * @Author Tripp Collins
     * @param seconds
     */
    public void startTimedRollersIntake(double seconds) {
        double startTime = Timer.getFPGATimestamp();
        double currentTime = Timer.getFPGATimestamp();
        while ((currentTime-startTime) < seconds) {
            intakeMotor.set(rollerSpeed);
        }
        intakeMotor.set(0);
    }

    /**
     * Starts the rollers to outake for a certain amount of seconds
     * @Author Tripp Collins
     * @param seconds
     */
    public void startTimedRollersOuttake(double seconds) {
        double startTime = Timer.getFPGATimestamp();
        double currentTime = Timer.getFPGATimestamp();
        while ((currentTime-startTime) < seconds) {
            intakeMotor.set(-rollerSpeed);
        }
        intakeMotor.set(0);
    }

    /**
     * Stops the rollers from spining
     * @Author Tripp Collins
     */
    public void stopRollers() {
        intakeMotor.set(0);

    }
}
