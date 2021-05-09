package dev.nymann.domain.commands;

import dev.nymann.domain.exceptions.CommandExecutionException;
import dev.nymann.domain.exceptions.SensorNotFoundException;

import java.util.List;

public abstract class Command implements ICommand {
    protected List<String> args;
    public Command(List<String> args) {
        this.args = args;
    }

    public abstract String execute() throws CommandExecutionException;
    public abstract void validateArguments();
}
