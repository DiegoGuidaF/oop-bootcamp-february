package oop.nato;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NatoParserTest {
    @Test
    public void itShouldReturnHotelWhenEncodingH() {
        assertEquals(NatoParser.encode("h"), "hotel");
    }

    @Test
    public void itShouldReturnEchoWhenEncodingE() {
        assertEquals(NatoParser.encode("e"), "echo");
    }
}
