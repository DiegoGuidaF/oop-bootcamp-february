package oop.nato;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NatoParser {

    public static final String DELIMITER = "-";

    public static String encode(String string) {
        return string.chars().mapToObj(i -> (char) i)
            .map(Alphabet.CHAR_TO_NATO::get)
            .collect(Collectors.joining(DELIMITER));
    }

    public static String decode(String inputString) {
        return Arrays.stream(inputString.split(DELIMITER))
            .map(Alphabet.CHAR_TO_NATO.inverse()::get).collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }
}
