package dev.nymann.domain.exceptions;

public class CommandExecutionException extends Exception {
    public CommandExecutionException(String message) {
        super(message);
    }
}
