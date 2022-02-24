package oop.parking.events;

import oop.parking.ParkingLot;

public class MaxLimitCapacityReachEvent implements Event {
    private final ParkingLot parkingLot;

    public MaxLimitCapacityReachEvent(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public Object getSubject() {
        return parkingLot;
    }
}
