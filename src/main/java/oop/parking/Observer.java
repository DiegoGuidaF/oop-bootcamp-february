package oop.parking;

import oop.parking.events.CapacityEvent;

public interface Observer {
    void update(CapacityEvent event);
}
