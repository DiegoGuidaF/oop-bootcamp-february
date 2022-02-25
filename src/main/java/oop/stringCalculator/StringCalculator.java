package oop.stringCalculator;

public class StringCalculator {

    public static int calculateFrom(String inputString) {
        if (inputString.isEmpty()){
            return  0;
        }
        return Integer.parseInt(inputString);
    }
}
