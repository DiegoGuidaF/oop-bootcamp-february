package oop.parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParkingLot {
    private static double MAX_PERCENTAGE_CAPACITY = 0.8;
    private final double capacity;
    private List<String> carIds;
    private List<Observer> observers = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carIds = new ArrayList<>(capacity);
    }

    public void carIn(String carId) {
        carIds.add(carId);
        if(exceedMaxCapacity()) notifyObservers("MaxLimitCapacityReach");
    }

    private boolean exceedMaxCapacity() {
        return carIds.size()/capacity >= MAX_PERCENTAGE_CAPACITY;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public List<String> getCarIds() {
        return carIds;
    }

    private void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }
}