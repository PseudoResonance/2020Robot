package com.chargerrobotics.commands.drive;

import com.chargerrobotics.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class BrakeCommand extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveSubsystem driveSubsystem;

    public BrakeCommand (DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
    }

    @Override
    public void initialize() {
        super.initialize();
        driveSubsystem.setBrake(true);
    }
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        driveSubsystem.setBrake(false);
    }
}