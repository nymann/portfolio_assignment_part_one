package dev.nymann.domain;

import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.TemperatureSensorAdapter;
import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

import java.util.HashMap;

public class SensorService {
    HashMap<String, ISensor> sensors;

    public SensorService() {
        sensors = new HashMap<>();
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
        if (sensor instanceof CO2SensorAdapter) {
            ((CO2SensorAdapter) sensor).stop();
        } else {
            ((TemperatureSensor) sensor).stop();
        }
        sensors.remove(name);
    }

}
