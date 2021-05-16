package dev.nymann.domain.commands;

import dev.nymann.domain.sensors.ISensorFactory;
import dev.nymann.domain.sensors.ISensorService;
import dev.nymann.domain.sensors.SensorFactory;
import dev.nymann.sensor.Sensor;

import java.util.List;

public class AddSensorCommand extends Command {

    private final ISensorService sensorService;
    private final ISensorFactory sensorFactory;

    public AddSensorCommand(List<String> args, ISensorService sensorService) {
        super(args);
        this.sensorService = sensorService;
        this.sensorFactory = new SensorFactory();
    }

    @Override
    public String execute() {
        validateArguments();
        String type = args.get(0);
        String name = args.get(1);

        Sensor sensor = sensorFactory.makeSensorFromTypeName(type, name);
        sensorService.add(sensor);
        return String.format("Added %s sensor device '%s'.", type, name);
    }

    @Override
    public void validateArguments() {
        if (this.args.size() != 2) {
            throw new IllegalArgumentException("The Add command takes 2 arguments (add <type> <name>).");
        }
    }
}