package oop.parking;

import oop.parking.events.CapacityEvent;
import oop.parking.events.Event;

public class Owner extends Notifier implements Observer {
    public static final double BUY_MORE_LAND_LIMIT = 0.75;
    private int countMoreLandNeeded = 0;

    public Owner() {
        super();
    }

    @Override
    public void update(Event event) {
        CapacityEvent capacityEvent = (CapacityEvent) event;
        if (capacityEvent.getNewCapacity() >= BUY_MORE_LAND_LIMIT) {
            countMoreLandNeeded++;
        }
    }

    public int getCountMoreLandNeeded() {
        return countMoreLandNeeded;
    }
}
