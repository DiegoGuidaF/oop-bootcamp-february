package oop.parking;

import oop.parking.errors.NoParkingAvailableError;
import oop.parking.events.CapacityEvent;

import java.util.ArrayList;
import java.util.List;

public class ParkingAssistant implements Observer {

    public static final double MAX_PARKING_CAPACITY = 0.8;
    private final ArrayList<ParkingLot> parkingLotsWithSpaceAvailable;

    public ParkingAssistant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLotsWithSpaceAvailable = parkingLots;
    }

    @Override
    public void update(CapacityEvent event) {
        if (event.getNewCapacity() >= MAX_PARKING_CAPACITY) {
            parkingLotsWithSpaceAvailable.remove(event.getParkingLot());
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
