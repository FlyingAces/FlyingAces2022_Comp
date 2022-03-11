package frc.robot.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.ControllerMap;
import frc.robot.config.RobotMap;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.utils.Conversions;

public class LaunchCommand extends Command
{
    private LauncherSubsystem _launcher;
    private JoystickButton _rBumper;


    public LaunchCommand(JoystickButton rBumper)
    {
        _launcher = LauncherSubsystem.getInstance();
        _rBumper = rBumper;
        requires(_launcher);
    }

    @Override
    public void execute()
    {
        _launcher.bothMotorsOn();
        if(_rBumper.get() == true) {
            _launcher.solenoidOn();
        }else {
            _launcher.solenoidOff();
        }
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
        _launcher.bothMotorsOff();
        _launcher.solenoidOff();
    }
}
