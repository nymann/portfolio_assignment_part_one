package dev.nymann.domain.commands;

import dev.nymann.domain.sensors.ISensorService;
import dev.nymann.domain.sensors.Sensor;
import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.TemperatureSensorAdapter;

import java.util.List;

public class AddSensorCommand extends Command {

    private final ISensorService sensorService;

    public AddSensorCommand(List<String> args, ISensorService sensorService) {
        super(args);
        this.sensorService = sensorService;
    }

    @Override
    public String execute() {
        validateArguments();
        String type = args.get(0);
        String name = args.get(1);

        String upperCaseType = type.toUpperCase();

        Sensor sensor = switch (upperCaseType) {
            case "TEMP" -> new TemperatureSensorAdapter(name);
            case "CO2" -> new CO2SensorAdapter(name);
            default -> throw new IllegalStateException("Invalid sensor type: " + type);
        };
        sensorService.add(sensor);
        return String.format("Added %s sensor device '%s'.", upperCaseType, name);
    }

    @Override
    public void validateArguments() {
        if (this.args.size() != 2) {
            throw new IllegalArgumentException("The Add command takes 2 arguments (add <type> <name>).");
        }
    }
}
