package dev.nymann.domain.exceptions;

public class SensorNotFoundException extends CommandExecutionException {
    public SensorNotFoundException(String sensorName) {
        super("A sensor with name: " + sensorName + ", could not be found.");
    }
}
