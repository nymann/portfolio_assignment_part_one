package dev.nymann.domain.commands;

import dev.nymann.domain.sensors.ISensorService;

import java.util.List;

public class ReadSensorCommand extends Command {
    private final ISensorService sensorService;
    public ReadSensorCommand(List<String> args, ISensorService sensorService) {
        super(args);
        this.sensorService = sensorService;
    }

    @Override
    public String execute() {
        String name = this.args.get(0);
        Double value = this.sensorService.read(name);
        return String.format("%s: %f", name, value);
    }

    @Override
    public void validateArguments() {
        if (this.args.size() != 1) {
            throw new IllegalArgumentException("Read takes 1 argument.");
        }

    }
}
