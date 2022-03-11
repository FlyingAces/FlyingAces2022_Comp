package frc.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.LauncherSubsystem;

// TODO: fill autonomous command [DONE]
public class AutonomousCommand extends CommandGroup
{
	private LauncherSubsystem _launcher;
	public AutonomousCommand()
	{
		_launcher = LauncherSubsystem.getInstance();
		// distance in inches
		addSequential(new DriveToCommand(-72));
		addSequential(new AutoShootCommand(), 2);
		addSequential(new AutoFlickCommand(), 2);

	}
}
