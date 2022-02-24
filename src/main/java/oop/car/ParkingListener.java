package oop.car;

public interface ParkingListener {

    void checkParkingOccupancy(int currentCapacity, int totalNumberOfSpaces,
        String parkingName);
}
