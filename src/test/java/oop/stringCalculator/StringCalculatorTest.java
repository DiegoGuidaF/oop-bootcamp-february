package oop.stringCalculator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StringCalculatorTest {

  private StringCalculator stringCalculator;

  @BeforeMethod
  public void setUp() {
    stringCalculator = new StringCalculator();
  }

  @Test
  public void itShouldReturnZeroWhenInputAnEmptyString() {
    String emptyString = "";
    assertEquals(stringCalculator.calculate(emptyString), 0);
  }

  @Test
  public void itShouldReturnTheSameValueThatItGivesAsString() {
    String stringValue = "4";
    assertEquals(stringCalculator.calculate(stringValue), 4);
  }
}
