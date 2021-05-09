package dev.nymann.presentation;

import dev.nymann.domain.commands.CommandFactory;
import dev.nymann.domain.commands.ICommand;
import dev.nymann.domain.exceptions.CommandExecutionException;
import dev.nymann.domain.sensors.ISensorService;
import dev.nymann.domain.sensors.SensorService;

import java.util.Scanner;

public class Client {
    Scanner scanner;
    ISensorService sensorService;

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
        try {
            ICommand command = new CommandFactory().makeFromString(userInput, sensorService);
            if (command == null) {
                help();
                return;
            }
            System.out.println(command.execute());
        } catch (CommandExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    private String readInput() {
        return scanner.nextLine();
    }

    private void help() {
        System.out.println("""
                'help', prints this message.
                'add co2 <name>', adds a CO2 sensor with the given name.
                'add temp <name>', adds a Temperature sensor with the given name.
                'read <name>', read the value of a previously added sensor.
                'remove <name>', stops the given sensor.
                'list', prints all sensor names along with their values.
                """);
    }
}
