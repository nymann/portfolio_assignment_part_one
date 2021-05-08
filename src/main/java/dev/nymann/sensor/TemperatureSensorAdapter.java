package dev.nymann.sensor;

import dev.nymann.domain.Sensor;
import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

public class TemperatureSensorAdapter extends Sensor {
    private final TemperatureSensor temperatureSensor;
    private final String name;

    public TemperatureSensorAdapter(String name) {
        temperatureSensor = new TemperatureSensor();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return (Double) temperatureSensor.value();
    }

    public void start() {
        temperatureSensor.start();
    }

    public void stop() {
        temperatureSensor.stop();
    }
}
