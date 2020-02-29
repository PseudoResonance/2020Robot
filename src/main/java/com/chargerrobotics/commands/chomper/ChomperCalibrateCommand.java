package com.chargerrobotics.commands.chomper;

import com.chargerrobotics.Constants;
import com.chargerrobotics.subsystems.ChomperSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ChomperCalibrateCommand extends CommandBase {
    private final ChomperSubsystem chomperSubsystem;
    private double encoderRef;
    private boolean isDone;

    public ChomperCalibrateCommand(ChomperSubsystem chomperSubsystem) {
        this.chomperSubsystem = chomperSubsystem;
    }

    @Override
    public void initialize() {
        isDone = false;
        chomperSubsystem.setUpDownSpeed(-0.3);
    }

    @Override
    public void execute() {
        if(chomperSubsystem.isLimitSwitchTriggered()) {
            encoderRef = chomperSubsystem.chomperUpDownPosition();
            isDone = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isDone;
    }

    @Override
    public void end(boolean interrupted) {
        chomperSubsystem.setUpDownSpeed(0);
        chomperSubsystem.setChomperTargetDown(encoderRef - Constants.chomperDistToDown);
        chomperSubsystem.setChomperTargetUp(chomperSubsystem.getChomperTargetDown() + Constants.chomperDistBottomToUp);
    }
}
