package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.utils.Conversions;

public class TurnToCommand extends Command
{
	private DrivetrainSubsystem _drivetrain;
	private double _degree;
	private double _arcLength;

	public TurnToCommand(double degree)
	{
		_drivetrain = DrivetrainSubsystem.getInstance();
		_degree = degree;
		_arcLength = (degree/360) * 22.5 * Math.PI;
		_arcLength = Conversions.convertPositionToEncoderPulses(_arcLength, 6);
		_drivetrain.zeroDrivetrain();

		requires(_drivetrain);
	}

	@Override
	protected void initialize()
	{
		_drivetrain.zeroDrivetrain();
	}

	@Override
	protected void execute()
	{
		_drivetrain.arcadeDrive(0, (_degree / Math.abs(_degree)/2.5));
		System.out.println("Drivetrain POS: " + Math.abs(_drivetrain.getRightCurrentPosition()));
		System.out.println("Arc Len: " + Math.abs(_arcLength));
		System.out.println("End" + (Math.abs(_drivetrain.getRightCurrentPosition()) >=  Math.abs(_arcLength)));
	}

	@Override
	protected boolean isFinished()
	{

		return Math.abs(_drivetrain.getRightCurrentPosition()) >=  Math.abs(_arcLength);

	}

	@Override
	protected void interrupted()
	{
		end();
	}

	@Override
	protected void end()
	{
		_drivetrain.arcadeDrive(0,0);
	}
}
