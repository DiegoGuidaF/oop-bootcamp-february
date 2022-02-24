package oop.car;

public class NotificationManager implements ParkingListener {

    @Override
    public void checkParkingOccupancy(int currentCapacity, int totalNumberOfSpaces,
        String parkingName) {
        printNotification(parkingName);
    }

    private void printNotification(String parkingName) {
        System.out.printf("Parking %s is lower than 20 percent", parkingName);
    }
}
