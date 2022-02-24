package oop.parking;

import oop.parking.events.CarInEvent;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends Notifier {
    private final double capacity;
    private final List<String> carIds;

    public ParkingLot(int capacity) {
        super();
        this.capacity = capacity;
        this.carIds = new ArrayList<>(capacity);
    }

    public void carIn(String carId) {
        carIds.add(carId);
        notifyObservers(new CarInEvent(this));
    }

    public List<String> getCarIds() {
        return carIds;
    }

    public double calculateCurrentCapacityUsage() {
        return carIds.size() / capacity;
    }
}