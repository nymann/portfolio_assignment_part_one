package dev.nymann.domain.sensors;

import dev.nymann.domain.exceptions.SensorNotFoundException;

import java.util.Collection;

public interface ISensorService {
    void add(Sensor sensor);

    Double read(String name);

    void remove(String name) throws SensorNotFoundException;

    Collection<Sensor> getSensors();
}
