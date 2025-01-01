package org.example.test;
import org.example.dao.BookingDAO;
import org.example.model.Booking;
import org.example.service.BookingService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class BookingServiceTest {
    public static void main(String[] args) {
        try {
            // set up connection to the h2 database
            Connection connection = DriverManager.getConnection("jdbc:h2:./bus booking_db", "sa", "");

            // Intialize bookingDao and BookingService
            BookingDAO bookingDAO = new BookingDAO(connection);
            BookingService bookingService = new BookingService(bookingDAO);

            // Test: add a booking
            Booking booking1 = new Booking("John Doe", "Bus 101", "2025-01-10", "10:00 AM");
            bookingService.addBooking(booking1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
