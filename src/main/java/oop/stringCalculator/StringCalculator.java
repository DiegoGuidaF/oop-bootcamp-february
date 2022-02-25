package oop.stringCalculator;

public class StringCalculator {

  public int calculate(String stringToCalculate) {
    if(stringToCalculate.isEmpty()){
      return 0;
    }
    return Integer.parseInt(stringToCalculate);
  }
}
