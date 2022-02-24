package oop.parking;

import oop.parking.events.CarInEvent;
import oop.parking.events.CloseParkingLotEvent;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
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

    @Test
    public void itShouldNotifiedWhenClosingAParkingLotWhenParkingLotUsageGoesLessMinCapacityUsage() {
        Owner owner = new Owner();
        Observer observer = mock(Observer.class);
        owner.registerObserver(observer);
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.calculateCurrentCapacityUsage()).thenReturn(0.2);

        ArgumentCaptor<CloseParkingLotEvent> argumentCloseEvent = ArgumentCaptor.forClass(CloseParkingLotEvent.class);

        owner.update(new CarInEvent(parkingLot));

        verify(observer).update(argumentCloseEvent.capture());
        assertEquals(argumentCloseEvent.getValue().getParkingLot(), parkingLot);
    }
}