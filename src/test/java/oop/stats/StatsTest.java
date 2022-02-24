package oop.stats;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatsTest {

  private Stats stats;

  @BeforeMethod
  public void setUp() {
    int[] listOfIntegers = {3,5,5,1,6};
    stats = new Stats(listOfIntegers);
  }

  @Test
  public void itShouldReturnTheMinimumOfAnArrayOfIntegers() {
    assertEquals(stats.findTheMinimum(), 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Not a valid list")
  public void itShouldReturnExceptionWhenReceivingAnEmptyList() {
    new Stats(new int[]{});
  }

  @Test
  public void itShouldReturnTheMaximumOfAnArrayOfIntegers() {
    assertEquals(stats.findTheMaximum(), 6);
  }
}
