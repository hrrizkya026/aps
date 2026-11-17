package com.travel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.travel.exception.IncompleteProfileException;
import com.travel.exception.InvalidBookingReferenceException;
import com.travel.model.Booking;
import com.travel.model.BookingStatus;
import com.travel.model.Flight;
import com.travel.model.UserProfile;

public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();

    // US5: Validasi Profil
    public void validateProfileAndTicket(UserProfile profile) {
        if (!profile.isComplete()) {
            throw new IncompleteProfileException("Data profil tidak lengkap");
        }
    }

    // US8: Pemesanan untuk pengunjung
    public Booking createBooking(Flight flight, String passengerName) {
        String refCode = "TRV-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        Booking newBooking = new Booking(refCode, flight, passengerName);
        bookings.add(newBooking);
        return newBooking;
    }

    // US7: Melihat semua booking atau filter status
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        if (status == null) return bookings;
        return bookings.stream().filter(b -> b.getStatus() == status).toList();
    }

    // US9: Otorisasi Manajer Travel
    public void authorizeBooking(String referenceCode) {
        Booking booking = bookings.stream()
                .filter(b -> b.getReferenceCode().equals(referenceCode))
                .findFirst()
                .orElseThrow(() -> new InvalidBookingReferenceException("Kode booking reference tidak sesuai"));
        
        booking.setStatus(BookingStatus.CONFIRMED);
    }
}