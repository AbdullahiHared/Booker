package org.example.model;

public class Booking {
    private int bookingId;
    private int busId;
    private String username;
    private String date;

    // Constructor
    public Booking(int bookingId, int busId, String username, String date) {
        this.bookingId = bookingId;
        this.busId = busId;
        this.username = username;
        this.date = date;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // toString method
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", busId=" + busId +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
