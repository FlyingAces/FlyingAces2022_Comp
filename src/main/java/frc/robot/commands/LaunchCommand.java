package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.ControllerMap;
import frc.robot.config.RobotMap;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.utils.Conversions;

public class LaunchCommand extends Command
{
    private LauncherSubsystem _launcher;
    private boolean _bumperStatus;


    public LaunchCommand(boolean bumperStatus)
    {
        _launcher = LauncherSubsystem.getInstance();
        _bumperStatus = bumperStatus;
        requires(_launcher);
    }

    @Override
    public void execute()
    {
        _launcher.bothMotorsOn();
        if(_bumperStatus) {
            _launcher.solenoidOn();
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
