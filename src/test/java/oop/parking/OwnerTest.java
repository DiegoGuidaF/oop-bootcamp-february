package oop.parking;

import oop.parking.events.CarInEvent;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class OwnerTest {
    @Test
    public void itShouldWantToBuyNewLandWhenAParkingNotifyCapacityOverBuyMoreLandLimit() {
        Owner owner = new Owner();
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.calculateCurrentCapacityUsage()).thenReturn(0.75);

        owner.update(new CarInEvent(parkingLot));

        assertEquals(owner.getCountMoreLandNeeded(), 1);
    }
}