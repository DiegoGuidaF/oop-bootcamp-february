package oop.parking;

import oop.parking.events.Event;

public interface Observer {
    void update(Event event);
}
