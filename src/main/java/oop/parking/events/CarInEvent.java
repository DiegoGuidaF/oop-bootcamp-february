package oop.parking.events;

import oop.parking.ParkingLot;

public class CarInEvent implements Event {
    private final ParkingLot parkingLot;

    public CarInEvent(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public Object getSubject() {
        return parkingLot;
    }
}
