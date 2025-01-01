package org.example.test;

import org.example.dao.BookingDAO;
import org.example.database.DatabaseConnection;
import org.example.database.SchemaInitializer;
import org.example.model.Booking;

import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;

public class BookingDaoTest {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Initialize the schema
            SchemaInitializer.initializeSchema(connection);

            // Add sample buses required for foreign key constraints
            connection.createStatement().executeUpdate("""
                    INSERT INTO buses (name, route, capacity) VALUES
                    ('Bus A', 'Route 1', 40),
                    ('Bus B', 'Route 2', 30);
                    """);

            // Create BookingDAO instance
            BookingDAO bookingDAO = new BookingDAO(connection);

            // Test: Add a booking
            Booking booking1 = new Booking();
            booking1.setBusId(1);
            booking1.setPassengerName("John Doe");
            booking1.setBookingDate(new Date(Calendar.getInstance().getTimeInMillis()));
            bookingDAO.addBooking(booking1);

            // Test: Add another booking
            Booking booking2 = new Booking();
            booking2.setBusId(2);
            booking2.setPassengerName("Jane Smith");
            booking2.setBookingDate(new Date(Calendar.getInstance().getTimeInMillis()));
            bookingDAO.addBooking(booking2);

            // Test: Retrieve all bookings
            System.out.println("All Bookings:");
            bookingDAO.getAllBookings().forEach(booking ->
                    System.out.println(booking.getId() + ": " + booking.getBusId() + " - " +
                            booking.getPassengerName() + " - " + booking.getBookingDate()));

            // Test: Retrieve booking by ID
            Booking bookingById = bookingDAO.getBookingById(1);
            System.out.println("Booking by ID:");
            System.out.println(bookingById.getId() + ": " + bookingById.getBusId() + " - " +
                    bookingById.getPassengerName() + " - " + bookingById.getBookingDate());

            //Test: Delete booking by ID
            System.out.println("Deleting booking with ID 1");
            bookingDAO.deleteBookingById(1);

            // Test: Retrieve all bookings after deletion
            System.out.println("All Bookings after deletion:");
            bookingDAO.getAllBookings().forEach(booking ->
                    System.out.println(booking.getId() + ": " + booking.getBusId() + " - " +
                            booking.getPassengerName() + " - " + booking.getBookingDate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
