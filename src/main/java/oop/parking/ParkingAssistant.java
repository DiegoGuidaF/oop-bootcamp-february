package oop.parking;

import java.util.List;

public class ParkingAssistant implements Observer {

    private List<ParkingLot> parkingLots;

    public ParkingAssistant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public void update(String event) {

    }
}
