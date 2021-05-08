package dev.nymann.domain;

import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.TemperatureSensorAdapter;
import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

import java.util.HashMap;

public class SensorService {
    HashMap<String, ISensor> sensors;

    public SensorService() {
    }

    public void addTemperatureSensor(String name) {
        var sensor = new TemperatureSensorAdapter(name);
        sensor.start();
        addSensor(name, sensor);
    }

    public void addCO2Sensor(String name) {
        var sensor = new CO2SensorAdapter(name);
        sensor.start();
        addSensor(name, sensor);
    }

    private void addSensor(String name, ISensor sensor) {
        sensors.put(name, sensor);
    }

    public Double getSensorValue(String name) {
        ISensor sensor = sensors.get(name);
        return sensor.getValue();
    }

    public void removeSensor(String name) {
        ISensor sensor = sensors.get(name);
        try {
            ((CO2SensorAdapter) sensor).stop();
        } catch (Exception e) {
            ((TemperatureSensor) sensor).stop();
        }
        sensors.remove(name);
    }

}
