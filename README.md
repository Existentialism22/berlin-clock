# Berlin Clock
Berlin Clock Java Implementation

## What is it?

![Berlin Clock Photo](berlin_clock.jpg "Berlin Clock")

Berlin Clock description: The time is calculated by adding the lit
rectangular lamps. The top lamp is a pump which is blinking on/off every
two seconds. In the topmost line of red lamps every lamp represents 5
hours. In the second line of red lamps every lamp represents 1 hour. So
if in the first line 2 lamps are lit and in the second line 3 lamps its
5+5+3=13h or 1 p.m. In the third line with tall lamps every lamp
represents 5 minutes. There are 11 lamps, the 3rd, 6th, and 9th are red
indicating the first quarter, half, and the last quarter of the hour. In
the last line with yellow lamps every lamp represents 1 minute.​

## Design Decisions

This implementation of Berlin Clock accepts 3 parameters as below;

* hour (0-23)
* minute (0-59)
* second (0-59)

And it will return a multi-line String as below;

```
Y             <== topmost lamp (row 0);
RRRR          <== top line of red lamps;
RXXX          <== second line of red lamps;
YYRYYRYYRXX   <== third row of red/yellow lamps;
YXXX          <== fourth row of yellow lamps;
```

Each character in the response is represented as below;

* Y => Lamp is ON and YELLOW
* R => Lamp is ON and RED
* X => Lamp is OFF

## Ambiguity

Not having seen the clock in person, I have interpreted that 'blinking on/off every two seconds' to be 'light comes on for two seconds and then off for two seconds'


## How to Run

1. Please clone this repo.
2. Please use java7 or java8 and run maven.
3. Packaging build an uber-jar that is executable.
4. When run, it will print out the current time in Berlin Clock. 

```
git clone https://github.com/tkoa001/berlin-clock.git
cd berlin-clock
mvn clean install
java -jar target/berlin-clock-1.0-SNAPSHOT.jar
```
