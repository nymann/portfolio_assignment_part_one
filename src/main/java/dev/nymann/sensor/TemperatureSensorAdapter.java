package dev.nymann.sensor;

import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

public class TemperatureSensorAdapter extends Sensor {
    private final TemperatureSensor temperatureSensor;
    private final String name;

    public TemperatureSensorAdapter(String name) {
        temperatureSensor = new TemperatureSensor();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getValue() {
        return (Double) temperatureSensor.value();
    }

    @Override
    public void start() {
        temperatureSensor.start();
    }

    @Override
    public void stop() {
        temperatureSensor.stop();
    }
}
