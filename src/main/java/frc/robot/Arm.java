package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;


public class Arm {

    public SparkMax leftarmMotor;
    public SparkMax rightarmMotor;
    

    public Arm(double speed) {
        this.leftarmMotor = new SparkMax(4, MotorType.kBrushed);
        this.rightarmMotor = new SparkMax(5, MotorType.kBrushed);

        leftarmMotor.set(speed);
        rightarmMotor.set(-speed);
    }


}