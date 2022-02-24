package oop.stats;

import java.util.Arrays;

public class Stats {

  private int[] listOfIntegers;

  public Stats(int[] listOfIntegers) {
    if (listOfIntegers.length == 0){
      throw new IllegalArgumentException("Not a valid list");
    }
    this.listOfIntegers = listOfIntegers;

  }

  public int findTheMinimum() {
    return Arrays.stream(listOfIntegers).min().getAsInt();
  }

  public int findTheMaximum() {
    return Arrays.stream(listOfIntegers).max().getAsInt();
  }
}
