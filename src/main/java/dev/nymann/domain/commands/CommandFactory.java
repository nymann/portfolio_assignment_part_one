package dev.nymann.domain.commands;

import dev.nymann.domain.sensors.ISensorService;

import java.util.Arrays;
import java.util.List;

public class CommandFactory implements ICommandFactory {
    @Override
    public ICommand makeFromString(String userInput, ISensorService sensorService) {
        String[] split = userInput.split(" ");
        List<String> args = Arrays.asList(split).subList(1, split.length);
        String command = split[0];

        return switch (command) {
            case "add" -> new AddSensorCommand(args, sensorService);
            case "remove" -> new RemoveSensorCommand(args, sensorService);
            case "read" -> new ReadSensorCommand(args, sensorService);
            case "list" -> new ListSensorsCommand(args, sensorService);
            default -> null;
        };
    }
}
