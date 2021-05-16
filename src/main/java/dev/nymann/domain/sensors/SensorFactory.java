package dev.nymann.domain.sensors;

import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.Sensor;
import dev.nymann.sensor.TemperatureSensorAdapter;

public class SensorFactory implements ISensorFactory {
    public Sensor makeSensorFromTypeName(String type, String name) {
        String upperCaseType = type.toUpperCase();
        return switch (upperCaseType) {
            case "TEMP" -> new TemperatureSensorAdapter(name);
            case "CO2" -> new CO2SensorAdapter(name);
            default -> throw new IllegalStateException("Invalid sensor type: " + type);
        };
    }
}
