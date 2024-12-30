package org.example.service;


import org.example.model.Booking;
import org.example.dao.BookingDAO;
import java.util.List;

public class BookingService {
    private BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDao) {
         this.bookingDAO = bookingDao;
    }

    // Add a booking
    public boolean addBooking(Booking booking) {
        // validation logic
        if(booking.getPassengerName() == null || booking.getPassengerName().isEmpty()) {
            System.out.println("Invalid passenger name. Booking not added.");
            return false;
        }
        bookingDAO.addBooking(booking);
        System.out.println("Booking added.");
        return true;
    }

    // Update booking
    public boolean updateBooking(Booking booking) {
        if(booking.getPassengerName() == null || booking.getPassengerName().isEmpty()) {
            System.out.println("Invalid passenger name. Booking not added.");
            return false;
        }
        bookingDAO.updateBooking(booking);
        System.out.println("Booking updated.");
        return true;
    }

    // Delete booking
    public boolean deleteBooking(int bookingId) {
        if(bookingId <= 0) {
            System.out.println("Invalid booking id: Booking not deleted.");
            return false;
        }
        bookingDAO.deleteBookingById(bookingId);
        System.out.println("Booking deleted.");
        return true;
    }

    //Get booking by id
    public boolean getBookingById(int bookingId) {
        if(bookingId <= 0) {
            System.out.println("Invalid booking id: No booking with given id.");
            return false;
        }
        bookingDAO.getBookingById(bookingId);
        return true;
    }

    // get all bookings
    public List<Booking> getBookings() {
            return bookingDAO.getAllBookings();
    }
}
