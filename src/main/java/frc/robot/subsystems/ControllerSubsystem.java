package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BumpCommand;

import frc.robot.commands.LaunchCommand;
import frc.robot.config.ControllerMap;

public class ControllerSubsystem extends Subsystem
{
    private static ControllerSubsystem _instance;
    private final Joystick _joystick;

    private ControllerSubsystem()
    {
        _joystick = new Joystick(ControllerMap.JOYSTICK_PORT);

        // Create buttons for the controller
        JoystickButton xButton = new JoystickButton(_joystick, ControllerMap.X_BUTTON);
        JoystickButton aButton = new JoystickButton(_joystick, ControllerMap.A_BUTTON);
        JoystickButton yButton = new JoystickButton(_joystick, ControllerMap.Y_BUTTON);
        JoystickButton bButton = new JoystickButton(_joystick, ControllerMap.B_BUTTON);
        JoystickButton rBumper = new JoystickButton(_joystick, ControllerMap.RIGHT_BUMPER);

        // Assign commands to buttons
        xButton.whileHeld(new LaunchCommand(rBumper.get()));

    }

    public static ControllerSubsystem getInstance()
    {
        if (_instance == null)
            _instance = new ControllerSubsystem();

        return _instance;
    }

    public Joystick getJoystick()
    {
        return _joystick;
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
