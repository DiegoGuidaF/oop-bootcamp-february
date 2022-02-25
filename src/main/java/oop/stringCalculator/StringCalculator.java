package oop.stringCalculator;

import java.util.Arrays;

public class StringCalculator {

    public static final String SUM_DELIMITER = ",";

    public int calculate(String stringToCalculate) {
        if (stringToCalculate.isEmpty()) {
            return 0;
        }
        return Arrays.stream(stringToCalculate.split(SUM_DELIMITER))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
