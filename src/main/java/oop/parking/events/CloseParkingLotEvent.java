package oop.parking.events;

import oop.parking.ParkingLot;

public class CloseParkingLotEvent implements Event{
    private final ParkingLot parkingLot;

    public CloseParkingLotEvent(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Object getParkingLot() {
        return parkingLot;
    }

}
