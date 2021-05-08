package dev.nymann.domain;

import java.util.HashMap;
import java.util.List;

public class SensorService implements ISensorService {
    // todo make it another class instead of Hashmap.
    HashMap<String, Sensor> sensors;

    public SensorService() {
        this.sensors = new HashMap<>();
    }

    public void add(Sensor sensor) {
        sensor.start();
        this.sensors.put(sensor.getName(), sensor);
    }

    public Double read(String name) {
        ISensor sensor = this.sensors.get(name);
        return sensor.getValue();
    }

    public List<Sensor> getSensors() {
        return (List<Sensor>) this.sensors.values();
    }

    public void remove(String name) {
        Sensor sensor = this.sensors.get(name);
        if (sensor == null) {
            return;
        }
        sensor.stop();
        this.sensors.remove(name);
    }

}
