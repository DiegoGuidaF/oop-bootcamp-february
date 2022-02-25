package oop.greeter;

import java.time.Clock;
import java.time.LocalTime;

// Write a Greeter class with greet function that receives a name as input and outputs Hello <name>. The signature of greet should not change throughout the kata. You are allowed to construct Greeter object as you please.
//greet trims the input
//greet capitalizes the first letter of the name
//greet returns Good morning <name> when the time is 06:00-12:00
//greet returns Good evening <name> when the time is 18:00-22:00
//greet returns Good night <name> when the time is 22:00-06:00
public class Greet {
    private final Clock clock;

    public Greet(Clock clock) {
        this.clock = clock;
    }

    public String greet(String name) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
        LocalTime localTime = LocalTime.now(clock);
        if (localTime.isAfter(LocalTime.of(6, 0)) && localTime.isBefore(LocalTime.of(12, 0))) {
            return String.format("Good morning %s", capitalizedName.trim());
        } else if(localTime.isAfter(LocalTime.of(18, 0)) && localTime.isBefore(LocalTime.of(22, 0))){
            return String.format("Good evening %s", capitalizedName.trim());
        }
        return String.format("Hello %s", capitalizedName.trim());
    }
}
