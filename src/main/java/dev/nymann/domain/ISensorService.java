package dev.nymann.domain;

public interface ISensorService {
    public void add(Sensor sensor);
    public Double read(String name);
    public void remove(String name);
}
