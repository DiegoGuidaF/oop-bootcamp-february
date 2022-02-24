package oop.greeter;

import org.testng.annotations.Test;

import java.time.Clock;

import static org.testng.Assert.assertEquals;

public class GreetTest {
    Clock clock = Clock.systemDefaultZone();

    Greet greet = new Greet(clock);

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
        assertEquals(greet.greet("chuck Norris "), "Hello Chuck Norris");
    }

    //TODO: Fake time of clock in order to place it in the morning
    //@Test
    //public void itShouldGreetMorningDuringMorningTime() {
    //    assertEquals(greet.greet("Chuck Norris"), "Good morning Chuck Norris");
    //}

}