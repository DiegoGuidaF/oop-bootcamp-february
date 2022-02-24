package oop.car;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public static final double MAX_CAPACITY_RATIO = 0.8;
    public static final double NOTIFY_CAPACITY_RATIO = 0.75;
    private final int maxCapacity;
    private final int notifyCapacityThreshold;
    private final List<Integer> parkedCars;
    private final int numberOfSpaces;
    private final ParkingListener parkingListener;
    private final String parkingName;

    public ParkingLot(int numberOfSpaces, ParkingListener parkingListener, String parkingName) {
        this.numberOfSpaces = numberOfSpaces;
        this.parkingListener = parkingListener;
        this.parkingName = parkingName;
        this.parkedCars = new ArrayList<>(numberOfSpaces);
        this.maxCapacity = (int) (MAX_CAPACITY_RATIO * numberOfSpaces);
        this.notifyCapacityThreshold = (int) (NOTIFY_CAPACITY_RATIO * numberOfSpaces);
    }

    public boolean parkCar(int carId) {
        if (parkedCars.size() >= maxCapacity) {
            return false;
        }
        parkedCars.add(carId);
        parkingListener.checkParkingOccupancy(parkedCars.size(), numberOfSpaces, parkingName);
        return true;
    }

    public int getFreeSpots() {
        return numberOfSpaces - parkedCars.size();
    }
}
