package oop.parking.events;

import oop.parking.ParkingLot;

public interface CapacityEvent extends Event {
    ParkingLot getParkingLot();
    double getNewCapacity();
}
