package oop.greeter;

import org.testng.annotations.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.testng.Assert.assertEquals;

public class GreetTest {

    Greet greet = setupGreetWithFakeTime("2018-08-22T00:00:00Z");

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
        Greet greetMorning = setupGreetWithFakeTime("2018-08-22T08:00:00Z");
        assertEquals(greetMorning.greet("Chuck Norris"), "Good morning Chuck Norris");
    }

    @Test
    public void itShouldGreetEveningDuringEveningTime() {
        Greet greetEvening = setupGreetWithFakeTime("2018-08-22T18:30:00Z");
        assertEquals(greetEvening.greet("Chuck Norris"), "Good evening Chuck Norris");
    }

    @Test
    public void itShouldGreetNightDuringNightTime() {
        Greet greetNight = setupGreetWithFakeTime("2018-08-22T22:30:00Z");
        assertEquals(greetNight.greet("Chuck Norris"), "Good night Chuck Norris");
    }

    private Greet setupGreetWithFakeTime(String s) {
        return new Greet(Clock.fixed(Instant.parse(s), ZoneOffset.UTC));
    }

}