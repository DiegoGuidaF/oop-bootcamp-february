package oop.car;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class NotificationManagerTest {

    public static final String PARKING_LOT = "PARKING_1";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    NotificationManager notificationManager = new NotificationManager();

    @BeforeMethod
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterMethod
    public void tearDown() {
        System.setOut(standardOut);
        outputStreamCaptor.reset();
    }

    @Test
    public void itShouldPrintLowOccupancyNotificationWhenCarParkingIsLowerThanThreshold() {
        int lowOccupancyThreshold = 20;
        String lowOccupancyMessage = String.format("Parking %s is lower than %d percent", PARKING_LOT, lowOccupancyThreshold);
        notificationManager.checkParkingOccupancy(1, 10, PARKING_LOT);
        assertEquals(lowOccupancyMessage, outputStreamCaptor.toString());
    }

    @Test
    public void itShouldPrintOccupancyNotificationWhenCarParkingIsHigherThanThreshold() {
        int highOccupancyThreshold = 75;
        String highOccupancyMessage = String.format("Parking %s is higher than %d percent", PARKING_LOT, highOccupancyThreshold);
        notificationManager.checkParkingOccupancy(10, 10, PARKING_LOT);
        assertEquals(highOccupancyMessage, outputStreamCaptor.toString());
    }

    @Test
    public void itShouldNotPrintOccupancyNotificationWhenCarParkingIsAtMediumOccupancy() {
        notificationManager.checkParkingOccupancy(5, 10, PARKING_LOT);
        assertEquals("", outputStreamCaptor.toString());
    }

}
