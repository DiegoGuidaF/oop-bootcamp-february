package oop.car;

public class Owner implements ParkingListener {

    public static final double HIGH_CAPACITY_RATIO = 0.75;
    public static final double LOW_CAPACITY_RATIO = 0.20;


    @Override
    public void checkParkingOccupancy(int currentCapacity, int totalNumberOfSpaces,
                                      String parkingName) {
        double occupancyPercentage = (double) currentCapacity / totalNumberOfSpaces;
        String occupancyStatus = "";

        if (occupancyPercentage >= HIGH_CAPACITY_RATIO) {
            occupancyStatus = "higher than 75 percent";
        } else if (occupancyPercentage <= LOW_CAPACITY_RATIO) {
            occupancyStatus = "lower than 20 percent";
        }

        if (!occupancyStatus.isBlank()) {
            printNotification(parkingName, occupancyStatus);
        }
    }

    private void printNotification(String parkingName, String occupancyStatus) {
        System.out.printf("Parking %s is %s", parkingName, occupancyStatus);
    }
}
