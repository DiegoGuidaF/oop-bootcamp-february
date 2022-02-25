package oop.nato;

import java.util.stream.Collectors;

public class NatoParser {
    public static String encode(String string) {
        return  string.chars().mapToObj(i->(char)i)
                .map(Alphabet.characterToNATO::get)
                .collect(Collectors.joining());
    }
}
