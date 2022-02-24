package oop.car;

public interface ParkingListener {
    String printNotification(String parkingName);

    void checkParkingOccupancy(int currentCapacity, int totalNumberOfSpaces);
}
