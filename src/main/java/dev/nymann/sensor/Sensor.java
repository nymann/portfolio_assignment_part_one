package dev.nymann.sensor;

public abstract class Sensor implements ISensor {
    public abstract void start();
    public abstract void stop();
}