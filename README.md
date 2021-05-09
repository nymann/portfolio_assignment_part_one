# Portfolio assignment (P1)

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
domain
├── commands
│   ├── AddSensorCommand.java
│   ├── CommandFactory.java
│   ├── Command.java
│   ├── ICommandFactory.java
│   ├── ICommand.java
│   ├── ListSensorsCommand.java
│   ├── ReadSensorCommand.java
│   └── RemoveSensorCommand.java
├── exceptions
│   ├── CommandExecutionException.java
│   └── SensorNotFoundException.java
└── sensors
├── ISensorFactory.java
├── ISensor.java
├── ISensorService.java
├── SensorFactory.java
├── Sensor.java
└── SensorService.java
presentation
└── Client.java
sensor
├── CO2SensorAdapter.java
└── TemperatureSensorAdapter.java
```
