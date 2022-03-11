package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LauncherSubsystem;

public class AutoShootCommand extends Command {
	private LauncherSubsystem _launcher;

	public AutoShootCommand() {
		_launcher = LauncherSubsystem.getInstance();
	}
	@Override
	protected void initialize()
	{
		_launcher.zeroLauncher();
	}

	@Override
	protected void execute()
	{
		_launcher.bothMotorsOn();
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
	}
}

