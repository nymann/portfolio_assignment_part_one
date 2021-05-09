package dev.nymann.domain.commands;

import dev.nymann.domain.exceptions.CommandExecutionException;

public interface ICommand {
    String execute() throws CommandExecutionException;

    void validateArguments();
}
