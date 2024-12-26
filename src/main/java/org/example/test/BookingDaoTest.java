package org.example.test;

import org.example.dao.BookingDAO;
import org.example.model.Booking;
import org.example.database.DatabaseConnection;
import org.example.database.SchemaInitializer;
import java.sql.Connection;

public class BookingDaoTest {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Inialize the schema
            SchemaInitializer.initializeSchema(connection);


            // Create BookingDAO instance
            BookingDAO bookingDAO = new BookingDAO(connection);

            // Test: Add a booking
            Booking booking = new Booking();
            booking.setBusId(1);
            booking.setUserId(1);
            booking.setBookingDate(new java.util.Date());
            bookingDAO.addBooking(booking);

            // Test : Add a booking
            Booking booking2 = new Booking();
            booking2.setBusId(2);
            booking2.setUserId(2);
            booking2.setBookingDate(new java.util.Date());
            bookingDAO.addBooking(booking2);

            // Test: Retrieve all bookings
            System.out.println("All Bookings:");
            for(Booking b : bookingDAO.getAllBookings()) {
                System.out.println(b.getId() + ": " + b.getBusId() + " - " + b.getUserId() + " - " + b.getBookingDate());
            }

            // Test: Retrieve booking by ID
            Booking bookingById = bookingDAO.getBookingById(1);
            System.out.println("Booking by ID:");
            System.out.println(bookingById.getId() + ": " + bookingById.getBusId() + " - " + bookingById.getUserId() + " - " + bookingById.getBookingDate());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
