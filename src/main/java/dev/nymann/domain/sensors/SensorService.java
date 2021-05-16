package dev.nymann.domain.sensors;

import dev.nymann.domain.exceptions.SensorNotFoundException;
import dev.nymann.sensor.ISensor;
import dev.nymann.sensor.Sensor;

import java.util.Collection;
import java.util.HashMap;

public class SensorService implements ISensorService {
    // todo make it another class instead of Hashmap.
    HashMap<String, Sensor> sensors;

    public SensorService() {
        this.sensors = new HashMap<>();
    }

    @Override
    public void add(Sensor sensor) {
        sensor.start();
        this.sensors.put(sensor.getName(), sensor);
    }

    @Override
    public Double read(String name) {
        ISensor sensor = this.sensors.get(name);
        return sensor.getValue();
    }

    @Override
    public Collection<Sensor> getSensors() {
        return this.sensors.values();
    }

    @Override
    public void remove(String name) throws SensorNotFoundException {
        Sensor sensor = this.sensors.get(name);
        if (sensor == null) {
            throw new SensorNotFoundException(name);
        }
        sensor.stop();
        this.sensors.remove(name);
    }
}
