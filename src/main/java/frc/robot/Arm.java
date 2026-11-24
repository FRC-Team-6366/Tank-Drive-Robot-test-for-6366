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
        this.clawMotor = new SparkMax(6, MotorType.kBrushed);
        this.speed = speed;

    }
    public void claw(double speed){
        clawMotor.set(speed);
    }
    public void rotatarm(double speed) {
        leftarmMotor.set(speed);
        rightarmMotor.set(-speed);
        if (m_minlimitSwitch.get() && speed < 0) {
            leftarmMotor.set(0);
            rightarmMotor.set(0);
        } else if (m_maxlimitSwitch.get() && speed < 0) {
            leftarmMotor.set(0);
            rightarmMotor.set(0);
        } else {
            leftarmMotor.set(speed);
            rightarmMotor.set(-speed);
        }
    }

}
