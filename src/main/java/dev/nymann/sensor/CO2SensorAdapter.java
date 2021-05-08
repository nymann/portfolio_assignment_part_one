package dev.nymann.sensor;

import dev.nymann.domain.ISensor;
import dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor;

public class CO2SensorAdapter implements ISensor {
    private final CO2Sensor co2Sensor;

    public CO2SensorAdapter(String id) {
        co2Sensor = new CO2Sensor(id);
    }

    @Override
    public String getName() {
        return co2Sensor.getId();
    }

    @Override
    public Double getValue() {
        int val = co2Sensor.getValue();
        return (double) val;
    }

    public void start() {
        co2Sensor.start();
    }

    public void stop() {
        co2Sensor.stop();
    }
}
