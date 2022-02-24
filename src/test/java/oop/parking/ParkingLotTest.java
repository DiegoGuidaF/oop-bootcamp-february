package oop.parking;

import oop.parking.events.MaxLimitCapacityReachEvent;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ParkingLotTest {
    @Test
    public void itShouldRegisterANewObserver() {
        ParkingLot parkingLot  = new ParkingLot(5);
        Observer observer = mock(Observer.class);

        parkingLot.registerObserver(observer);

        assertTrue(parkingLot.getObservers().contains(observer));
    }

    @Test
    public void whenParkingItShouldAddACar() {
        ParkingLot parkingLot  = new ParkingLot(5);

        String carId = "carId";
        parkingLot.carIn(carId);

        assertTrue(parkingLot.getCarIds().contains(carId));
    }

    @Test
    public void whenNotReachingMaxLimitCapacityShouldNotNotifyObservers() {
        ParkingLot parkingLot  = new ParkingLot(5);
        Observer observer = mock(Observer.class);
        parkingLot.registerObserver(observer);
        ArgumentCaptor<MaxLimitCapacityReachEvent> argument = ArgumentCaptor.forClass(MaxLimitCapacityReachEvent.class);

        String carId = "carId";
        parkingLot.carIn(carId);

        verify(observer, never()).update(argument.capture());
    }

    @Test
    public void whenReachingMaxLimitCapacityShouldNotifyObservers() {
        ParkingLot parkingLot  = new ParkingLot(5);
        Observer observer = mock(Observer.class);
        parkingLot.registerObserver(observer);
        ArgumentCaptor<MaxLimitCapacityReachEvent> argument = ArgumentCaptor.forClass(MaxLimitCapacityReachEvent.class);

        for (int i = 0; i < 4; i++) {
            parkingLot.carIn("carId" + i);
        }

        verify(observer).update(argument.capture());
        assertEquals(argument.getValue().getSubject(), parkingLot);
    }
}
