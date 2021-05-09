package dev.nymann.domain.commands;


import dev.nymann.domain.exceptions.CommandExecutionException;
import dev.nymann.domain.exceptions.SensorNotFoundException;
import dev.nymann.domain.sensors.ISensorService;

import java.util.List;

public class RemoveSensorCommand extends Command {
    private final ISensorService sensorService;

    public RemoveSensorCommand(List<String> args, ISensorService sensorService) {
        super(args);
        this.sensorService = sensorService;
    }

    @Override
    public String execute() throws CommandExecutionException {
        validateArguments();
        String name = args.get(0);
        sensorService.remove(name);
        return String.format("Removed sensor device '%s'.", name);
    }

    @Override
    public void validateArguments() {
        if (this.args.size() != 1) {
            throw new IllegalArgumentException("The Remove command takes 1 argument.");
        }
    }
}
