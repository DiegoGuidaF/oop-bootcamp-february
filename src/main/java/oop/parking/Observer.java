package oop.parking;

import oop.parking.events.MaxLimitCapacityReachEvent;

public interface Observer {
    void update(MaxLimitCapacityReachEvent event);
}
