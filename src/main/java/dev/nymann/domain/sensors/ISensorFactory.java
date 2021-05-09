package dev.nymann.domain.sensors;

public interface ISensorFactory {
    public Sensor makeSensorFromCommand(String command, String name);
}
