package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;


import edu.wpi.first.wpilibj.DigitalInput;

import java.nio.channels.Channel;

import com.revrobotics.encoder.DetachedEncoder.PeriodicStatus0;
import com.revrobotics.spark.SparkMax;



public class Arm {

    public SparkMax leftarmMotor;
    public SparkMax rightarmMotor;
    public double speed;
    public SparkMax clawMotor;

    DigitalInput m_minlimitSwitch = new DigitalInput(0);
    DigitalInput m_maxlimitSwitch = new DigitalInput(1);
    

    public Arm(double speed) {
        this.leftarmMotor = new SparkMax(4, MotorType.kBrushed);
        this.rightarmMotor = new SparkMax(5, MotorType.kBrushed);
        this.speed = speed;
    
    }
    public void rotatarm(double speed){
        leftarmMotor.set(speed);
        rightarmMotor.set(-speed);
    }
    public void m_minlimitSwitch() {
        double m_minlimitSwitch ();

    
    }
    public claw(double speed){
        this.clawMotor = new SparkMax(6, MotorType.kBrushed);
        
    }
    

}
