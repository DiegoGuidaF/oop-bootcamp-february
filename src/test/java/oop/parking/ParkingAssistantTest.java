package oop.parking;

import oop.parking.errors.NoParkingAvailableError;
import oop.parking.events.CarInEvent;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class ParkingAssistantTest {
    @Test
    public void itShouldParkACarInTheFirstParkingLotAvailable() throws NoParkingAvailableError {
        ParkingLot parkingLot1 = mock(ParkingLot.class);
        ParkingLot parkingLot2 = mock(ParkingLot.class);
        ParkingAssistant parkingAssistant = new ParkingAssistant(new ArrayList<>(Arrays.asList(parkingLot1,parkingLot2)));
        String carId = "carId";

        parkingAssistant.parkIn(carId);

        verify(parkingLot1).carIn(carId);
        verify(parkingLot2, never()).carIn(carId);
    }

    @Test(expectedExceptions = { NoParkingAvailableError.class })
    public void whenNoParkingAreAvailableItShouldThrowANoParkingAvailableError() throws NoParkingAvailableError {
        ParkingAssistant parkingAssistant = new ParkingAssistant(new ArrayList<>());
        String carId = "carId";
        parkingAssistant.parkIn(carId);
    }

    @Test
    public void itShouldRemoveTheParkingLotWhenParkingLotExceedMaxCapacity() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        ParkingAssistant parkingAssistant = new ParkingAssistant(new ArrayList<>(Arrays.asList(parkingLot)));
        when(parkingLot.calculateCurrentCapacityUsage()).thenReturn(0.8);

        parkingAssistant.update(new CarInEvent(parkingLot));

        assertFalse(parkingAssistant.getParkingLotsWithSpaceAvailable().contains(parkingLot));
    }
}
