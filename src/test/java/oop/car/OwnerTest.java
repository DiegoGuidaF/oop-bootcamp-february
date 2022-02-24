package oop.car;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OwnerTest {

    Owner owner = new Owner();

    @Test
    public void itShouldPrintNotification() {
        assertEquals(owner.printNotification("PARKING_1"),
            "Parking PARKING_1 full capacity");
    }

    @Test
    public void itShouldPrintLowOccupancyNotificationWhenCarParkingIsAlmostEmpty() {
        assertEquals(owner.checkCapacity(1,10),
            "Parking PARKING_1 is EMPTY");
    }

    @Test
    public void itShouldPrintHighOccupancyNotificationWhenCarParkingIsAlmostFull() {
        assertEquals(owner.checkCapacity(9,10),
            "Parking PARKING_1 is FULL");
    }

}