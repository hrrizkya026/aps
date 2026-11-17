package com.travel.model;

public class Booking {
    private final String referenceCode;
    private final Flight flight;
    private final String passengerName;
    private BookingStatus status;

    public Booking(String referenceCode, Flight flight, String passengerName) {
        this.referenceCode = referenceCode;
        this.flight = flight;
        this.passengerName = passengerName;
        this.status = BookingStatus.WAITING_FOR_PAYMENT;
    }

    public String getReferenceCode() { return referenceCode; }
    public Flight getFlight() { return flight; }
    public String getPassengerName() { return passengerName; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
}