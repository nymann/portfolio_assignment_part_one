package dev.nymann.domain.commands;

import dev.nymann.domain.sensors.ISensorService;
import dev.nymann.domain.sensors.Sensor;
import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.TemperatureSensorAdapter;

import java.util.Collection;
import java.util.List;

public class ListSensorsCommand extends Command {

    private final ISensorService sensorService;

    public ListSensorsCommand(List<String> args, ISensorService sensorService) {
        super(args);
        this.sensorService = sensorService;
    }

    @Override
    public String execute() {
        validateArguments();
        Collection<Sensor> sensors = sensorService.getSensors();
        StringBuilder stringBuilder = new StringBuilder();
        for (Sensor sensor: sensors) {
            String line = String.format("%s: %f\n", sensor.getName(), sensor.getValue());
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    @Override
    public void validateArguments() {
        if (this.args.size() != 0) {
            throw new IllegalArgumentException("The List command takes 0 arguments.");
        }
    }
}
