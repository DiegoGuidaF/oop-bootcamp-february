package oop.car;

import java.util.Comparator;
import java.util.List;

//"A parking lot assistant handles multiple parking lots, parking a car in the first parking lot with space"

//A parking lot assistant handles multiple parking lots, parking a car in the first parking lot with space"
//"A parking lot assistant parks a car in a parking lot only if it is less than 80% full"

//"I (owner) want to be notified when a parking lot usage is over 75% so that I can buy more land"

// ----------
//"A parking lot assistant parks large cars in the parking lot with the least % of usage"

//"A parking lot assistant parks handicapped cars in the first parking lot that accepts handicapped cars"

// "A parking lot assistant can only park fancy cars (e.g.: Lamborghinis, Ferraris, …) if she/he's certified for it"

// "“A parking lot assistant can hire assistants to manage some of the parking lots”
public class ParkingAssistant {
    private final List<ParkingLot> parkingLots;

    public ParkingAssistant(List<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public boolean parkCar(int carId) {
        return parkCar(carId, CarType.AVERAGE);
    }

    public boolean parkCar(int carId, CarType carType) {
        if (carType.equals(CarType.LARGE)) {
            parkingLots.sort(Comparator.comparing(ParkingLot::getFreeSpots));
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.parkCar(carId)) {
                return true;
            }
        }
        return false;

    }
}