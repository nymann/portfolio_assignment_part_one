package dev.nymann;


import dev.nymann.sensor.CO2SensorAdapter;
import dev.nymann.sensor.TemperatureSensorAdapter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        var s = new CO2SensorAdapter("CO2 Sensor");
        var t = new TemperatureSensorAdapter("Temperature Sensor");

        s.start();
        t.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(s.getValue());
            System.out.println(t.getValue());
        }

        s.stop();
        t.stop();
    }
}