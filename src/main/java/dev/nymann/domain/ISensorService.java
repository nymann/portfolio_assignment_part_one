package dev.nymann.domain;

import java.util.List;

public interface ISensorService {
    public void add(Sensor sensor);
    public Double read(String name);
    public void remove(String name);
    public List<Sensor> getSensors();
}
