package oop.parking;

import oop.parking.errors.NoParkingAvailableError;

import java.util.List;

public class ParkingAssistant implements Observer {

    private final List<ParkingLot> parkingLotsWithSpaceAvailable;

    public ParkingAssistant(List<ParkingLot> parkingLots) {
        this.parkingLotsWithSpaceAvailable = parkingLots;
    }

    @Override
    public void update(String event) {

    }

    public void parkIn(String carId) throws NoParkingAvailableError {
        try {
            parkingLotsWithSpaceAvailable.get(0).carIn(carId);
        } catch (IndexOutOfBoundsException err) {
            throw new NoParkingAvailableError();
        }
    }
}
