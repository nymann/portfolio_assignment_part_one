package dev.nymann.presentation;

import dev.nymann.domain.SensorFactory;
import dev.nymann.domain.SensorService;
import dev.nymann.sensor.TemperatureSensorAdapter;

import java.util.Scanner;

public class Client {
    Scanner scanner;
    SensorService sensorService;

    public Client() {
        sensorService = new SensorService();
        scanner = new Scanner(System.in);
        help();
        while (true) {
            loop();
        }
    }

    public void loop() {
        var userInput = readInput();
        var split = userInput.split(" ");
        if (split.length != 2) {
            help();
            return;
        }
        String command = split[0];
        String name = split[1];
        ProcessCommand(command, name);
    }

    private String readInput() {
        return scanner.nextLine();
    }

    private void ProcessCommand(String command, String name) {
        switch (command) {
            case "add_temp", "add_co2" -> {
                var sensor = new SensorFactory().makeSensorFromCommand(command, name);
                sensorService.add(sensor);
            }
            case "read" -> printSensorValue(name);
            case "remove" -> sensorService.remove(name);
            case "list" -> printSensors();
            default -> help();
        }
    }

    private void printSensorValue(String name) {
        var temp = sensorService.read(name);
        if (temp == null) {
            printMessage("A sensor with that name does not exist.");
            return;
        }
        printMessage(String.format("%s: %f", name, temp));
    }

    private void help() {
        printMessage("""
                'help', prints this message.
                'add_co2 <name>', adds a CO2 sensor with the given name.
                'add_temp <name>', adds a Temperature sensor with the given name.
                'read <name>', read the value of a previously added sensor.
                'remove <name>', stops the given sensor.
                'list all', prints all sensor names along with their values.
                """);
    }

    private void printSensors() {
        var sensors = sensorService.getSensors();
        for (var name : sensors.keySet()) {
            printMessage(name + ": " + sensors.get(name));
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
