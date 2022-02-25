package oop.stringCalculator;

public class StringCalculator {

    public static int calculateFrom(String inputString) {
        if (inputString.isEmpty()){
            return  0;
        }
        int positionOfComma = inputString.indexOf(",");
        if(positionOfComma == -1){
            return Integer.parseInt(inputString);
        }
        int firstNumber = Integer.parseInt(inputString.substring(0, positionOfComma));
        int secondNumber = Integer.parseInt(inputString.substring(positionOfComma+1));
        return firstNumber + secondNumber;
    }
}
