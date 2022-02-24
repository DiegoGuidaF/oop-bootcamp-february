package oop.parking;

import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertFalse;
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
        String event = "MaxLimitCapacityReach";

        String carId = "carId";
        parkingLot.carIn(carId);

        verify(observer, never()).update(event);
    }

    @Test
    public void whenReachingMaxLimitCapacityShouldNotifyObservers() {
        ParkingLot parkingLot  = new ParkingLot(5);
        Observer observer = mock(Observer.class);
        parkingLot.registerObserver(observer);
        String event = "MaxLimitCapacityReach";

        for (int i = 0; i < 4; i++) {
            parkingLot.carIn("carId" + i);
        }

        verify(observer).update(event);
    }
}
