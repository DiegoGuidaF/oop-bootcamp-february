package oop.parking.events;

import oop.parking.ParkingLot;

public class CarInEvent implements CapacityEvent {
    private final ParkingLot parkingLot;

    public CarInEvent(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public Object getParkingLot() {
        return parkingLot;
    }

    @Override
    public double getNewCapacity() {
        return parkingLot.calculateCurrentCapacityUsage();
    }
}
