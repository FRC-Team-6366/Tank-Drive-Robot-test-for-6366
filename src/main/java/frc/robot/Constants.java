package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Constants {
    /**
     * this is the variable that defines the amount of time the robot
     * needs to go forward before it is TIME TO TURN!!!!
     */
    public static double timeToTurn = 1.8;
    public static double endOfTurn = 3.7;
    public static double timeToStop = 5.2+0.5;
    public static double driveSpeed = 0.6;
    public static double turnSpeed = 0.3;


    // Intake constants
    public static int intakeMotorId = 3;
    public static double intakeSpeed = 0.6;
    public static MotorType intakeMotorType = MotorType.kBrushed;
}