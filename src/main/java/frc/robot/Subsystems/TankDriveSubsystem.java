package frc.robot.Subsystems;

import java.util.Vector;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDriveSubsystem extends SubsystemBase {
    
    private CANSparkMax frontLeftMotor;
    private CANSparkMax backLeftMotor;
    private CANSparkMax frontRightMotor;
    private CANSparkMax backRightMotor;

    public TankDriveSubsystem(){
        // init motors
        // Motors aren't all 0 port 
        this.frontLeftMotor = new CANSparkMax(56, CANSparkMaxLowLevel.MotorType.kBrushed);
        this.backLeftMotor = new CANSparkMax(17, CANSparkMaxLowLevel.MotorType.kBrushed);
        this.frontRightMotor = new CANSparkMax(47, CANSparkMaxLowLevel.MotorType.kBrushed);
        this.backRightMotor = new CANSparkMax(49, CANSparkMaxLowLevel.MotorType.kBrushed);
    }

    public void setPercentOutput(double speed, double dir) {
        System.out.println("Setting motor outputs");

        double leftPower = 0, rightPower = 0;

        if (dir == 0) {
            leftPower = speed;
            rightPower = -speed;
        }
        
        else if (speed == 0) {

            leftPower = speed * dir;
            rightPower = speed * dir;
        } else if (dir < 0) {
            // turn left
            leftPower = speed * (dir+1);
            rightPower = -speed;
        } else if (dir > 0) {
            // turn right
            leftPower = speed;
            rightPower = -speed * -(dir-1);
        }

        this.frontLeftMotor.set(leftPower);
        this.backLeftMotor.set(leftPower);
        this.frontRightMotor.set(rightPower);
        this.backRightMotor.set(rightPower);
    }

    public void stopMotors() {
        this.frontLeftMotor.set(0);
        this.backLeftMotor.set(0);
        this.frontRightMotor.set(0);
        this.backRightMotor.set(0);
    }
}
