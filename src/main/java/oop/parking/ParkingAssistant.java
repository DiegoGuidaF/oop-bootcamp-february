package oop.parking;

import oop.parking.errors.NoParkingAvailableError;
import oop.parking.events.Event;
import oop.parking.events.MaxLimitCapacityReachEvent;

import java.util.ArrayList;
import java.util.List;

public class ParkingAssistant implements Observer {

    private final ArrayList<ParkingLot> parkingLotsWithSpaceAvailable;

    public ParkingAssistant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLotsWithSpaceAvailable = parkingLots;
    }

    @Override
    public void update(Event event) {
        if (event.getClass() == MaxLimitCapacityReachEvent.class) {
            ParkingLot parkingLotToRemove = (ParkingLot) event.getSubject();
            parkingLotsWithSpaceAvailable.remove(parkingLotToRemove);
        }
    }

    public void parkIn(String carId) throws NoParkingAvailableError {
        try {
            parkingLotsWithSpaceAvailable.get(0).carIn(carId);
        } catch (IndexOutOfBoundsException err) {
            throw new NoParkingAvailableError();
        }
    }

    public List<ParkingLot> getParkingLotsWithSpaceAvailable() {
        return parkingLotsWithSpaceAvailable;
    }
}
