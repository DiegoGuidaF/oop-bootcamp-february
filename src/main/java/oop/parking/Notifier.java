package oop.parking;

import oop.parking.events.Event;

import java.util.ArrayList;
import java.util.List;

public abstract class Notifier {
    final List<Observer> observers;

    protected Notifier() {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    void notifyObservers(Event event) {
        observers.forEach(observer -> observer.update(event));
    }
}
