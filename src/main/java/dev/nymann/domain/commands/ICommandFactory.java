package dev.nymann.domain.commands;

import dev.nymann.domain.sensors.ISensorService;

public interface ICommandFactory {
    public ICommand makeFromString(String userInput, ISensorService sensorService);
}
