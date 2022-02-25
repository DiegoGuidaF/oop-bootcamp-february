package oop.greeter;

import java.time.Instant;
import java.time.ZoneId;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Clock;

import static org.mockito.Mockito.after;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class GreetTest {

  String morningInstant = "2022-02-25T10:15:30Z";
  String afternoonInstant = "2022-02-25T15:15:30Z";
  Clock clock = Clock.fixed(Instant.parse(morningInstant), ZoneId.of("UTC"));
  Greet greet = new Greet(clock);

  @Test
  public void itShouldReturnHelloNameInTheAfternoon() {
    Clock clock = Clock.fixed(Instant.parse(afternoonInstant), ZoneId.of("UTC"));
    Greet greet = new Greet(clock);
    assertEquals(greet.greet("Chuck Norris"), "Hello Chuck Norris");
  }

  @Test
  public void itShouldTrimInputAndReturnNameWhenGreet() {
    assertEquals(greet.greet("Chuck Norris "), "Good morning Chuck Norris");
  }

  @Test
  public void itShouldCapitalizeFirstLetterOfName() {
    assertEquals(greet.greet("chuck Norris"), "Good morning Chuck Norris");
  }

  @Test
  public void itShouldGreetMorningDuringMorningTime() {
    assertEquals(greet.greet("Chuck Norris"), "Good morning Chuck Norris");
  }

  @Test
  public void itShouldGreetGoodEveningDuringEveningTime() {



  }
}
