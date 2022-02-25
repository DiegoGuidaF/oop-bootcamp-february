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
        String capitalizedName = (name.substring(0, 1).toUpperCase() + name.substring(1)).trim();
        if (isTimeBetween(6, 12)) {
            return String.format("Good morning %s", capitalizedName);
        } else if (isTimeBetween(18, 22)) {
            return String.format("Good evening %s", capitalizedName);
        } else if (isTimeBetween(22, 23, true) ||
            isTimeBetween(0, 6)) {
            return String.format("Good night %s", capitalizedName);
        }
        return String.format("Hello %s", capitalizedName);
    }

    private boolean isTimeBetween(int beforeHour, int afterHour) {
        return isTimeBetween(beforeHour, afterHour, false);
    }

    private boolean isTimeBetween(int beforeHour, int afterHour, boolean isEndOfDay) {
        LocalTime localTime = LocalTime.now(clock);
        int minutes = 0;
        if (isEndOfDay) {
            minutes = LocalTime.MAX.getMinute();
        }
        return localTime.isAfter(LocalTime.of(beforeHour, 0)) &&
            localTime.isBefore(LocalTime.of(afterHour, minutes));
    }
}
