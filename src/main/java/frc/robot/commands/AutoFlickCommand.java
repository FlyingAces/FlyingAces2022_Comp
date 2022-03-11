package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LauncherSubsystem;

public class AutoFlickCommand extends Command {
	private LauncherSubsystem _launcher;

	public AutoFlickCommand() {
		_launcher = LauncherSubsystem.getInstance();
	}
	@Override
	protected void initialize()
	{

	}

	@Override
	protected void execute()
	{
		_launcher.bothMotorsOn(0.60);
		_launcher.solenoidOn();
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

	@Override
	protected void interrupted()
	{
		end();
	}

	@Override
	protected void end()
	{
		_launcher.bothMotorsOff();
		_launcher.solenoidOff();
	}
}