package oop.greeter;

import org.testng.annotations.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.testng.Assert.assertEquals;

public class GreetOnHourTest {

    GreetOnHour greet = setupGreetWithFakeTime(0);

    @Test
    public void itShouldReturnHelloName() {
        assertEquals(greet.greet("Chuck Norris"), "Hello Chuck Norris");
    }

    @Test
    public void itShouldTrimInputAndReturnNameWhenGreet() {
        assertEquals(greet.greet("Chuck Norris "), "Hello Chuck Norris");
    }

    @Test
    public void itShouldCapitalizeFirstLetterOfName() {
        assertEquals(greet.greet("chuck Norris"), "Hello Chuck Norris");
    }

    @Test
    public void itShouldGreetMorningDuringMorningTime() {
        GreetOnHour greetMorning = setupGreetWithFakeTime(8);
        assertEquals(greetMorning.greet("Chuck Norris"), "Good morning Chuck Norris");
    }

    @Test
    public void itShouldGreetEveningDuringEveningTime() {
        GreetOnHour greetEvening = setupGreetWithFakeTime(18);
        assertEquals(greetEvening.greet("Chuck Norris"), "Good evening Chuck Norris");
    }

    @Test
    public void itShouldGreetNightDuringNightTime() {
        GreetOnHour greetNight = setupGreetWithFakeTime(23);
        assertEquals(greetNight.greet("Chuck Norris"), "Good night Chuck Norris");
    }

    private GreetOnHour setupGreetWithFakeTime(int hour) {
        return new GreetOnHour(hour);
    }

}