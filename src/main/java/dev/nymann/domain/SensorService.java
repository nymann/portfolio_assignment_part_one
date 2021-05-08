package dev.nymann.domain;

import java.util.HashMap;

public class SensorService implements ISensorService {
    // todo make it another class instead of Hashmap.
    HashMap<String, Sensor> sensors;

    public SensorService() {
        sensors = new HashMap<>();
    }

    public void add(Sensor sensor) {
        sensor.start();
        sensors.put(sensor.getName(), sensor);
    }

    public Double read(String name) {
        ISensor sensor = sensors.get(name);
        return sensor.getValue();
    }

    public HashMap<String, Double> getSensors() {
        HashMap<String, Double> sensor_map = new HashMap<>();
        for (ISensor sensor : sensors.values()) {
            sensor_map.put(sensor.getName(), sensor.getValue());
        }
        return sensor_map;
    }

    public void remove(String name) {
        Sensor sensor = sensors.get(name);
        if (sensor == null) {
            return;
        }
        sensor.stop();
        sensors.remove(name);
    }

}
