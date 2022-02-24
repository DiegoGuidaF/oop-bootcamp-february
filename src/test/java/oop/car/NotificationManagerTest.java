package oop.car;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NotificationManagerTest {

    NotificationManager notificationManager = new NotificationManager();
    public static final String PARKING_LOT= "PARKING_1";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeTest
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterTest
    public void tearDown() {
        System.setOut(standardOut);
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
        int highOccupancyThreshold = 80;
        String highOccupancyMessage = String.format("Parking %s is higher than %d percent", PARKING_LOT, highOccupancyThreshold);
        notificationManager.checkParkingOccupancy(10, 10, PARKING_LOT);
        assertEquals(highOccupancyMessage, outputStreamCaptor.toString());
    }

}
