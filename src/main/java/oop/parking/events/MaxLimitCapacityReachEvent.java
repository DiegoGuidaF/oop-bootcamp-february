package oop.parking.events;

import oop.parking.ParkingLot;

public class MaxLimitCapacityReachEvent {
    private final ParkingLot parkingLot;

    public MaxLimitCapacityReachEvent(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
