package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class Constants {
    /**
     * this is the variable that defines the amount of time the robot
     * needs to go forward before it is TIME TO TURN!!!!
     */
    public static double timeToTurn = 0.9;
    public static double endOfTurn = 1.85;
    public static double timeToStop = 5.2+0.5;
    public static double timeToTurn2 = 2.75;
    public static double endOfTurn2 = 4.55;
    public static double timeToTurn3 = 5.45;
    public static double endOfTurn3 = 6.4;
    public static double timeToTurn4 = 8.2;
    public static double endOfTurn4 = 9.1;

    public static double driveSpeed = 0.6;
    public static double turnSpeed = 0.3;
    public static double armleftMotorid=4;
    public static double armrightMotorid=5;
    public static double armspeed=0.4;
    public static double clawMotorid=6;
    public static double m_maxlimitSwitchid=1;
    public static double m_minlimitSwitchid=0;

    // Intake constants
    public static int intakeMotorId = 3;
    public static double intakeSpeed = 0.6;
    public static MotorType intakeMotorType = MotorType.kBrushed;
}