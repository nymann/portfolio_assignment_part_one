# SNUS not UNIX Sensors
### Portfolio assignment part 1

### Install provided jar library
```shell
mvn install:install-file \
    -Dfile=lib/st4-scfs-sensors-1.0.0.jar \
    -DgroupId=dk.sdu.mmmi \
    -DartifactId=st4-scfs-sensors \
    -Dversion=1.0.0 \
    -Dpackaging=jar
```

### Structure
```
src/main/java/dev/nymann/
├── domain
│   ├── commands
│   │   ├── AddSensorCommand.java
│   │   ├── CommandFactory.java
│   │   ├── Command.java
│   │   ├── ICommandFactory.java
│   │   ├── ICommand.java
│   │   ├── ListSensorsCommand.java
│   │   ├── ReadSensorCommand.java
│   │   └── RemoveSensorCommand.java
│   ├── exceptions
│   │   ├── CommandExecutionException.java
│   │   └── SensorNotFoundException.java
│   └── sensors
│       ├── ISensorFactory.java
│       ├── ISensorService.java
│       ├── SensorFactory.java
│       └── SensorService.java
├── Main.java
├── presentation
│   └── Client.java
└── sensor
    ├── CO2SensorAdapter.java
    ├── ISensor.java
    ├── Sensor.java
    └── TemperatureSensorAdapter.java
```
