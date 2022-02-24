package oop.parking;

import oop.parking.events.CarInEvent;
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
        ArgumentCaptor<CarInEvent> argument = ArgumentCaptor.forClass(CarInEvent.class);

        String carId = "carId";
        parkingLot.carIn(carId);

        verify(observer).update(argument.capture());
        assertEquals(argument.getValue().getSubject(), parkingLot);
    }

    @Test
    public void itShouldReturnZeroWhenCalculatingTheCurrentCapacityUsageOfAnEmptyParkingLot() {
        ParkingLot parkingLot  = new ParkingLot(5);

        assertEquals(parkingLot.calculateCurrentCapacityUsage(), 0.0);
    }

    @Test
    public void itShouldReturnTheCurrentCapacityUsageOfAParkingLot() {
        ParkingLot parkingLot  = new ParkingLot(5);

        parkingLot.carIn("carId");

        assertEquals(parkingLot.calculateCurrentCapacityUsage(), 0.2);
    }
}
