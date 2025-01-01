package org.example.model;

import java.util.Date;

public class Booking {
    private int id;
    private int busId;
    private String passengerName;
    private String bookingDate;
    private String bookingTime;

    // Constructor
    public Booking(String passengerName, String busId, String bookingDate, String bookingTime) {
        this.passengerName = passengerName;
        this.busId = Integer.parseInt(busId);
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = String.valueOf(bookingDate);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", busId=" + busId +
                ", passengerName=" + passengerName +
                ", bookingDate=" + bookingDate +
                '}';
    }

}
