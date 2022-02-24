package oop.parking;

import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;

public class NotifierTest {
    @Test
    public void itShouldRegisterANewObserver() {
        Notifier notifier  = new ParkingLot(5);
        Observer observer = mock(Observer.class);

        notifier.registerObserver(observer);

        assertTrue(notifier.getObservers().contains(observer));
    }
}