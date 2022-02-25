package oop.greeter;

import java.time.Clock;
import java.time.LocalTime;

// Write a Greeter class with greet function that receives a name as input and outputs Hello <name>. The signature of greet should not change throughout the kata. You are allowed to construct Greeter object as you please.
//greet trims the input
//greet capitalizes the first letter of the name
//greet returns Good morning <name> when the time is 06:00-12:00
//greet returns Good evening <name> when the time is 18:00-22:00
//greet returns Good night <name> when the time is 22:00-06:00
public class GreetOnHour {
//    private static final Pair<LocalTime, LocalTime> MORNING_LIMITS = new ImmutablePair(LocalTime.of(6, 0), LocalTime.of(12, 0));
//    private static final Pair<LocalTime, LocalTime> EVENING_LIMITS = new ImmutablePair(LocalTime.of(12, 0), LocalTime.of(22, 0));
    private final int currentHour;

    public GreetOnHour(int currentHour) {
        this.currentHour = currentHour;
    }

    public String greet(String name) {
        String capitalizedName = (name.substring(0, 1).toUpperCase() + name.substring(1)).trim();
        if (isTimeBetween(6, 12)) {
            return String.format("Good morning %s", capitalizedName);
        } else if (isTimeBetween(18, 22)) {
            return String.format("Good evening %s", capitalizedName);
        } else if (isTimeBetween(22, 6+24)){
            return String.format("Good night %s", capitalizedName);
        }
        return String.format("Hello %s", capitalizedName);
    }

    private boolean isTimeBetween(int beforeHour, int afterHour) {
        return currentHour >= beforeHour && currentHour <= afterHour;
    }

}
