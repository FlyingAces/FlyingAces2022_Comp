package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.config.RobotMap;

public class LauncherSubsystem extends Subsystem
{
    private static LauncherSubsystem _instance;
    private final WPI_TalonSRX _leftMotor;
    private final WPI_TalonSRX _rightMotor;
    private final WPI_TalonSRX _rightVEX;
    private final WPI_TalonSRX _leftVEX;

    private LauncherSubsystem()
    {
        _leftMotor = new WPI_TalonSRX(RobotMap.LEFT_LAUNCHER_ID);
        _rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_LAUNCHER_ID);
        _leftVEX = new WPI_TalonSRX(RobotMap.LEFT_VEX);
        _rightVEX = new WPI_TalonSRX(RobotMap.RIGHT_VEX);
        _leftMotor.configFactoryDefault();
        _rightMotor.configFactoryDefault();
        _leftMotor.setNeutralMode(NeutralMode.Brake);
        _rightMotor.setNeutralMode(NeutralMode.Brake);
        _leftMotor.setInverted(true);
        _rightMotor.setInverted(true);
    }

    public void bothMotorsOn()
    {
        _leftMotor.set(ControlMode.PercentOutput, 0.5);
        _rightMotor.set(ControlMode.PercentOutput, 0.5);
    }

    public void bothMotorsOff()
    {
        _leftMotor.set(ControlMode.PercentOutput, 0);
        _rightMotor.set(ControlMode.PercentOutput, 0);
    }

    public void solenoidOn()
    {
        _leftVEX.set(ControlMode.PercentOutput, -0.5);
        _rightVEX.set(ControlMode.PercentOutput, 0.5);
    }

    public void solenoidOff()
    {
        _leftVEX.set(ControlMode.PercentOutput, 0);
        _rightVEX.set(ControlMode.PercentOutput, 0);
    }

    public double getLauncherPosition()
    {
        return _leftMotor.getSelectedSensorPosition(0);
    }

    public void zeroLauncher()
    {
        _leftMotor.setSelectedSensorPosition(0.0);
        _rightMotor.setSelectedSensorPosition(0.0);
    }

    public static LauncherSubsystem getInstance()
    {
        if (_instance == null)
            _instance = new LauncherSubsystem();

        return _instance;
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
