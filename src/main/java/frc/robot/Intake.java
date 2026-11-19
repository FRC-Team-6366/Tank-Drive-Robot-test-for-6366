package frc.robot;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.Timer;

public class Intake {
    double startTime; // value for time based roller functions

    boolean timedIntakeRolling; // timed roller constants
    boolean timedIntakeRollingDirection; // true = fowards, false = backwards
    double timedIntakeDuration;

    boolean rumbling; // is it rumbling 
    boolean rumblingCurrentDirection; // current direction, in or out. true = fowards, false = backwards
    double rumblingDuration; // duration to run
    double rumblingInterval; // time between changing
    double rumblingTimeSinceChanged;


    double rollerSpeed;  // motor constants
    SparkMax intakeMotor;
    /**
     * @Author Tripp Collins
     * @param motorID This is the intake motors can id
     * @param speed this is the speed that the motor will run at when it is activated
     */
    public Intake(int motorID, double speed) {
        if (speed >1.0){  // ensures we aren't sending a speed that the motors are unable to handle
            speed = 1.0;
        };
        

        if (speed < -1.0) {
            speed = -1.0;   // ensures we arent sending a speed that the motors are unable to handle
        };

        this.rollerSpeed = speed;
        this.intakeMotor = new SparkMax(motorID, Constants.intakeMotorType);

        // temporary values for timed rollers and rumble
        this.timedIntakeRolling = false;
        this.timedIntakeRollingDirection = false;
        this.timedIntakeDuration = 0.0;
        this.rumbling = false;
        this.rumblingCurrentDirection = false;
        this.rumblingDuration = 0.0;
        this.startTime = 0.0;
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
        /*double startTime = Timer.getFPGATimestamp();   // starting time 
        double currentTime = Timer.getFPGATimestamp();
        while ((currentTime-startTime) < seconds) {  // if we havent completed the time, continue running
            intakeMotor.set(rollerSpeed);
            currentTime = Timer.getFPGATimestamp();
        }
        intakeMotor.set(0); // stops the intake after we have completed the time*/
        if (seconds>0){
            startTime = Timer.getFPGATimestamp();
            timedIntakeDuration = seconds;
            timedIntakeRollingDirection = true;
            timedIntakeRolling = true;
        }
    }

    /**
     * Starts the rollers to outake for a certain amount of seconds
     * @Author Tripp Collins
     * @param seconds the amount of time the rollers should run for
     */
    public void startTimedRollersOuttake(double seconds) {
        /*double startTime = Timer.getFPGATimestamp();       // starting time
        double currentTime = Timer.getFPGATimestamp();
        while ((currentTime-startTime) < seconds) {      // if we havent completed the time, continue running
            intakeMotor.set(-rollerSpeed);
        }
        intakeMotor.set(0); // stops the intake after we have completed the time*/
        if (seconds>0){
            startTime = Timer.getFPGATimestamp();
            timedIntakeDuration = seconds;
            timedIntakeRollingDirection = false;
            timedIntakeRolling = true;
        }
    }

    /** This rumbles the roller back and forth to get balls unstuck
     * @Author Tripp Collins
     * @param seconds the amount of time intake should rumble for
     * @param interval the amount of time between changing roller direction
     */
    public void rumbleRollers(double seconds, double interval) {
        if (seconds>0 && interval > 0) {
            startTime = Timer.getFPGATimestamp();
            rumblingCurrentDirection = true;
            rumblingDuration = seconds;
            rumblingInterval = interval;
            rumbling = true;
        }
    }
    /**
     * Stops the rollers from spining
     * @Author Tripp Collins
     */
    public void stopRollers() {
        timedIntakeRolling = false;
        rumbling = false;
        intakeMotor.set(0); // sets the speed to 0

    }

    /**
     * Intake periodic to ensure we dont hang the robot on a while loop
     * @Author Tripp Collins
     */
    public void intakePeriodic() {
        if (timedIntakeRolling == true) {
            if ((Timer.getFPGATimestamp() - startTime) < timedIntakeDuration) { // if we havent hit duration, continue
                if (timedIntakeRollingDirection) {
                    intakeMotor.set(rollerSpeed);  // foward
                } else {
                    intakeMotor.set(-rollerSpeed);// backward
                }
            } else {
                stopRollers(); // stop cause we hit the duration, disables timedIntakeRolling
            }
        }

        if (rumbling == true) {
            if ((Timer.getFPGATimestamp() - startTime) < rumblingDuration) { // if we havent hit duration, continue
                if (Timer.getFPGATimestamp()-rumblingTimeSinceChanged < rumblingInterval) { // if we havent hit interval changing point then keep going
                    if (rumblingCurrentDirection == true) {
                        intakeMotor.set(rollerSpeed); // foward
                    } else {
                        intakeMotor.set(-rollerSpeed);// backward
                    }
                } else { // change since we hit interval
                    rumblingCurrentDirection=!rumblingCurrentDirection; // swaps value
                    if (rumblingCurrentDirection == true) { 
                        intakeMotor.set(rollerSpeed); // foward
                    } else {
                        intakeMotor.set(-rollerSpeed);// backward
                    }
                    rumblingTimeSinceChanged = Timer.getFPGATimestamp();
                }
            } else {
                stopRollers(); // stop cause we hit duration
            }
        }
    }
}
