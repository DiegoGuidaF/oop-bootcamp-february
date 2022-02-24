package oop.parking;

import oop.parking.events.CapacityEvent;

public class Owner implements Observer {
    public static final double BUY_MORE_LAND_LIMIT = 0.75;
    private int countMoreLandNeeded = 0;

    @Override
    public void update(CapacityEvent event) {
        if (event.getNewCapacity() >= BUY_MORE_LAND_LIMIT) {
            countMoreLandNeeded++;
        }
    }

    public int getCountMoreLandNeeded() {
        return countMoreLandNeeded;
    }
}
