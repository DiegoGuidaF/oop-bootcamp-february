package oop.parking;

import oop.parking.events.CarInEvent;
import oop.parking.events.Event;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final double capacity;
    private final List<String> carIds;
    private final List<Observer> observers = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carIds = new ArrayList<>(capacity);
    }

    public void carIn(String carId) {
        carIds.add(carId);
        notifyObservers(new CarInEvent(this));
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

    private void notifyObservers(Event event) {
        observers.forEach(observer -> observer.update(event));
    }

    public double calculateCurrentCapacityUsage() {
        return carIds.size()/capacity;
    }
}