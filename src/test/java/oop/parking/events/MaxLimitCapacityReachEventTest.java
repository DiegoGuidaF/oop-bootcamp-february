package oop.parking.events;

import oop.parking.ParkingLot;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;

public class MaxLimitCapacityReachEventTest {

    @Test
    public void itShouldReturnTheParkingLot() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        MaxLimitCapacityReachEvent event = new MaxLimitCapacityReachEvent(parkingLot);

        assertEquals(event.getSubject(), parkingLot);
    }
}