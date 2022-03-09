package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LauncherSubsystem;

public class BumpCommand extends Command
{
	private LauncherSubsystem _launcher;


	public BumpCommand()
	{
		_launcher = LauncherSubsystem.getInstance();
		requires(_launcher);
	}

	@Override
	public void execute()
	{
		_launcher.solenoidOn();
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
