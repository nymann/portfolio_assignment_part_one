package dev.nymann.presentation;

import dev.nymann.domain.SensorService;

import java.io.Console;

public class Client {
    Console console;
    SensorService sensorService;
    public Client() throws Exception {
        sensorService = new SensorService();
        console = System.console();
        if(console == null) {
            throw new Exception("No console available");
        }
        while(true) {
            loop();
        }
    }

    public void loop() {
        var userInput = readInput();
        getCommand(userInput);
    }

    private String readInput() {
       return console.readLine();
    }

    private void getCommand(String userInput) {
        switch (userInput) {
            case "help":
                help();
            case "add CO2 sensor":
                sensorService.addCO2Sensor("CO2");
                printMessage("Added CO2 sensor with name: 'CO2'");
                break;
            case "add Temperature sensor":
                sensorService.addTemperatureSensor("temp");
                printMessage("Added temperature sensor with name: 'temp'");
                break;
            case "read CO2":
                printSensorValue("CO2");
                break;
            case "read temp":
                printSensorValue("temp");
                break;
            default:
                help();
        }
    }

    private void printSensorValue(String name) {
        var temp = sensorService.getSensorValue(name);
        if (temp == null) {
            printMessage("A sensor with that name does not exist.");
            return;
        }
        printMessage(String.format("%s: %f", name, temp));
    }

    private void help() {
        printMessage("This is not very helpful.");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
