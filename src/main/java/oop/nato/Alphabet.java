package oop.nato;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static java.util.Map.entry;

public class Alphabet {
    private static final Map<Character, String> characterToNATO = ImmutableMap.ofEntries(
        entry('a', "alpha"),
        entry('b', "bravo"),
        entry('c', "charlie"),
        entry('d', "delta"),
        entry('e', "echo"),
        entry('f', "foxtrot"),
        entry('g', "golf"),
        entry('h', "hotel"),
        entry('i', "india"),
        entry('j', "juliett"),
        entry('k', "kilo"),
        entry('l', "lima"),
        entry('m', "mike"),
        entry('n', "november"),
        entry('o', "oscar"),
        entry('p', "papa"),
        entry('q', "quebec"),
        entry('r', "romeo"),
        entry('s', "sierra"),
        entry('t', "tango"),
        entry('u', "uniform"),
        entry('v', "victor"),
        entry('w', "whiskey"),
        entry('x', "xray"),
        entry('y', "yankee"),
        entry('z', "zulu"),
        entry('1', "one"),
        entry('2', "two"),
        entry('3', "three"),
        entry('4', "four"),
        entry('5', "five"),
        entry('6', "six"),
        entry('7', "seven"),
        entry('8', "eight"),
        entry('9', "nine"),
        entry('0', "zero"),
        entry(' ', "null")
    );
    public static final BiMap<Character, String> CHAR_TO_NATO = HashBiMap.create(characterToNATO);
}
