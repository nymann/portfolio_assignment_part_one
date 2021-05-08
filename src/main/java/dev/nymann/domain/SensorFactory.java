package dev.nymann.domain;

import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.TemperatureSensorAdapter;

public class SensorFactory {
    public Sensor makeSensorFromCommand(String command, String name) {
        switch (command) {
            case "add_co2" -> {
                return new CO2SensorAdapter(name);
            }
            case "add_temp" -> {
                return new TemperatureSensorAdapter(name);
            }
            default -> throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
