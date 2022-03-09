package frc.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;

// TODO: fill autonomous command [DONE]
public class AutonomousCommand extends CommandGroup
{
	public AutonomousCommand()
	{
		// distance in inches
		addSequential(new DriveToCommand(300));
	}
}
