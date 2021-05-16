package dev.nymann.domain.sensors;

import dev.nymann.sensor.Sensor;

public interface ISensorFactory {
    public Sensor makeSensorFromTypeName(String type, String name);
}
