package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class movement {
    private TalonSRX myMotor1, myMotor2, myMotor3, myMotor4;
    private double acceleration = 0.25; 
    public movement() {
        myMotor1 = new TalonSRX(1);
        myMotor2 = new TalonSRX(11);
        myMotor3 = new TalonSRX(2);
        myMotor4 = new TalonSRX(12);
        updateRampRate();
        myMotor3.setInverted(true);
    }

    private void updateRampRate() {
        myMotor1.configOpenloopRamp(acceleration);
        myMotor2.configOpenloopRamp(acceleration);
        myMotor3.configOpenloopRamp(acceleration);
        myMotor4.configOpenloopRamp(acceleration);
    }

    public void leftForward(double percent) {
        myMotor1.set(TalonSRXControlMode.PercentOutput, percent);
        myMotor2.set(TalonSRXControlMode.PercentOutput, percent);
    }

    public void rightForward(double percent) {
        myMotor3.set(TalonSRXControlMode.PercentOutput, percent);
        myMotor4.set(TalonSRXControlMode.PercentOutput, percent);
    }

    public double increase() {
        if (acceleration < 1.0) {
            acceleration += 0.05;
            updateRampRate();
        }
        return acceleration;
    }

    public double decrease() {
        if (acceleration > 0.0) {
            acceleration -= 0.05;
            updateRampRate();
        }
        return acceleration;
    }

    public void estop() {
        leftForward(0);
        rightForward(0);
    }
}