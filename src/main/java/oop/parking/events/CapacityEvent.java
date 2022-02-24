package oop.parking.events;

public interface CapacityEvent extends Event {
    Object getParkingLot();
    double getNewCapacity();
}
