package oop.stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int calculate(String stringToCalculate) {
        if (stringToCalculate.isEmpty()) {
            return 0;
        } else if (stringToCalculate.contains(",")) {
            List<Integer> integerList = Arrays.stream(stringToCalculate.split(",")).map(
                Integer::parseInt).collect(
                Collectors.toList());
            return integerList.stream()
                .reduce(0, Integer::sum);
        }
        return Integer.parseInt(stringToCalculate);
    }
}
