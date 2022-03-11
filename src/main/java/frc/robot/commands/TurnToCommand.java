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
	}

	@Override
	protected boolean isFinished()
	{
		return (_drivetrain.getLeftCurrentPosition()/ _drivetrain.getRightCurrentPosition()) >= _arcLength;
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
