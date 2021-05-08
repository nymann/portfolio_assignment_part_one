package dev.nymann.domain;

import java.util.Collection;

public interface ISensorService {
    public void add(Sensor sensor);
    public Double read(String name);
    public void remove(String name);
    public Collection<Sensor> getSensors();
}
