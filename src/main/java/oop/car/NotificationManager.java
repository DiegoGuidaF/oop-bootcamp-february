package oop.car;

public class NotificationManager implements ParkingListener {

    public String printNotification(String parkingName) {
        return String.format("Parking %s full capacity", parkingName);
    }

    @Override
    public void checkParkingOccupancy(int currentCapacity, int totalNumberOfSpaces) {

    }
}
