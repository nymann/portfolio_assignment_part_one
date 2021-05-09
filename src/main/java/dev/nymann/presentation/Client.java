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
        System.out.println(help());
        while (true) {
            ICommand command = getCommandFromUserInput();
            String response = getCommandResponseOrErrorMessage(command);
            System.out.println(response);
        }
    }

    private ICommand getCommandFromUserInput() {
        var userInput = readInput();
        return new CommandFactory().makeFromString(userInput, sensorService);
    }

    private String getCommandResponseOrErrorMessage(ICommand command) {
        try {
            return executeCommandOrDisplayHelp(command);
        } catch (CommandExecutionException e) {
            return e.getMessage();
        }
    }

    private String executeCommandOrDisplayHelp(ICommand command) throws CommandExecutionException {
        if (command == null) {
            return help();
        }
        return command.execute();
    }

    private String readInput() {
        return scanner.nextLine();
    }

    private String help() {
        return ("""
                'help', prints this message.
                'add co2 <name>', adds a CO2 sensor with the given name.
                'add temp <name>', adds a Temperature sensor with the given name.
                'read <name>', read the value of a previously added sensor.
                'remove <name>', stops the given sensor.
                'list', prints all sensor names along with their values.
                """);
    }
}
