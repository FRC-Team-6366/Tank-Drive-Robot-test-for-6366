package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class Constants {
    /**
     * this is the variable that defines the amount of time the robot
     * needs to go forward before it is TIME TO TURN!!!!
     */
        public static double timeToTurn = 0.9;
    public static double endOfTurn = timeToTurn + 0.95;
    public static double timeToTurn2 = endOfTurn +0.9;
    public static double endOfTurn2 = timeToTurn2 + 1.8;
    public static double timeToTurn3 = endOfTurn2 + 0.9;
    public static double endOfTurn3 = timeToTurn3 + 0.95;
    public static double timeToTurn4 = endOfTurn3 + 0.9;
    public static double endOfTurn4 = timeToTurn4 + 1.8;
    public static double driveSpeed = 0.6;
    public static double turnSpeed = 0.3;


    // Intake constants
    public static int intakeMotorId = 3;
    public static double intakeSpeed = 0.6;
    public static MotorType intakeMotorType = MotorType.kBrushed;

    public static double armleftMotorid=4;
    public static double armrightMotorid=5;
    public static double armspeed=0.4;
    public static double clawMotorid=6;
    public static double m_maxlimitSwitchid=1;
    public static double m_minlimitSwitchid=0;
}