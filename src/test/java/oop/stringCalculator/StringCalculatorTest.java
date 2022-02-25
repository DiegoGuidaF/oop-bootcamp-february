package oop.stringCalculator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringCalculatorTest {
 @Test
 public void itShouldReturnZeroOnEmptyString() {
     assertEquals(StringCalculator.calculateFrom(""), 0);
 }
 @Test
 public void itShouldReturnNumberWhenInputIsSingleDigit() {
     assertEquals(StringCalculator.calculateFrom("9"), 9);
 }
 @Test
 public void itShouldReturnTheSumOfTwoNumbersWhenCommaSeparated() {
     assertEquals(StringCalculator.calculateFrom("10,20"), 30);
 }
}