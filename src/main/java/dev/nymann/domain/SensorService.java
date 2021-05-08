package dev.nymann.domain;

import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.TemperatureSensorAdapter;

import java.util.HashMap;
import java.util.List;

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

    public HashMap<String, Double> getSensors() {
        HashMap<String, Double> sensor_map = new HashMap<>();
        for (ISensor sensor: sensors.values()) {
           sensor_map.put(sensor.getName(), sensor.getValue());
        }
        return sensor_map;
    }

    public void removeSensor(String name) {
        Object sensor = sensors.get(name);
        if (sensor == null) {
            return;
        }
        if (sensor instanceof CO2SensorAdapter) {
            ((CO2SensorAdapter) sensor).stop();
        } else {
            ((TemperatureSensorAdapter) sensor).stop();
        }
        sensors.remove(name);
    }

}
