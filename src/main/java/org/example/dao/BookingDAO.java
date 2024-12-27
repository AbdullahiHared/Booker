package org.example.dao;

import org.example.model.Booking;
import org.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private Connection connection;

    public BookingDAO(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    // Add a new booking
    public void addBooking(Booking booking) {
        String query = "INSERT INTO booking(bus_id, passenger_name, booking_date) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, booking.getBusId());
            pstmt.setString(2, booking.getPassengerName());
            pstmt.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setBusId(rs.getInt("bus_id"));
                booking.setPassengerName(rs.getString("passenger_name"));
                booking.setBookingDate(rs.getDate("booking_date"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Get booking by ID
    public Booking getBookingById(int id) {
        Booking booking = null;
        String query = "SELECT * FROM booking WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    booking = new Booking();
                    booking.setId(rs.getInt("id"));
                    booking.setBusId(rs.getInt("bus_id"));
                    booking.setPassengerName(rs.getString("passenger_name"));
                    booking.setBookingDate(rs.getDate("booking_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    // Update a booking
    public void updateBooking(Booking booking) {
        String query = "UPDATE booking SET bus_id = ?, user_id = ?, booking_date = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, booking.getBusId());
            pstmt.setString(2, booking.getPassengerName());
            pstmt.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
            pstmt.setInt(4, booking.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a booking
    public void deleteBooking(int id) {
        String query = "DELETE FROM booking WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
