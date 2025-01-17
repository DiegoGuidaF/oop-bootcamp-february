package oop.car;

import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ParkingLotTest {

    ParkingLot parkingLot;
    ParkingListener parkingListener = mock(ParkingListener.class);

    @Test
    public void itShouldParkCarWhenSpaceIsAvailable() {
        parkingLot = new ParkingLot(5, parkingListener, "TEST");
        assertTrue(parkingLot.parkCar(12));
    }

    @Test
    public void itShouldFailIfTheCapacityIsReached() {
        parkingLot = new ParkingLot(10, parkingListener, "TEST");
        parkMultipleCars(8);
        assertFalse(parkingLot.parkCar(9));
    }

    @Test
    public void itShouldFailWhenAddingCarIfTwoSpotsWithOneCar() {
        parkingLot = new ParkingLot(2, parkingListener, "TEST");
        assertTrue(parkingLot.parkCar(1));
        assertFalse(parkingLot.parkCar(2));
    }

    @Test
    public void itShouldNotifyOwnerWhenAlmostFull() {
        parkingLot = new ParkingLot(10, parkingListener, "PARKING_1");
        parkMultipleCars(8);
        verify(parkingListener).notifyMaxCapacity(eq("PARKING_1"));
    }

    @Test
    public void itShouldParkOutOneCar() {
        parkingLot = new ParkingLot(10, parkingListener, "PARKING_1");
        parkingLot.parkCar(1);
        //assertTrue(parkingLot.parkOut(1));
    }

    @Test
    public void itShouldNotifyOwnerWhenAlmostEmpty() {
        parkingLot = new ParkingLot(10, parkingListener, "PARKING_1");
        parkMultipleCars(8);
        //parkOutultipleCars(8);
        verify(parkingListener).notifyMaxCapacity(eq("PARKING_1"));
    }

    private void parkMultipleCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            assertTrue(parkingLot.parkCar(i));
        }
    }

}