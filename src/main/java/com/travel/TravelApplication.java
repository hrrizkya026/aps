package com.travel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.travel.model.Booking;
import com.travel.model.Employee;
import com.travel.model.Flight;
import com.travel.model.LeaveRequest;
import com.travel.model.UserProfile;
import com.travel.service.BookingService;
import com.travel.service.FlightService;
import com.travel.service.LeaveService;

public class TravelApplication {
    public static void main(String[] args) {
        System.out.println("=== DEMO APLIKASI VIBE CODING ===");

        // -- Test US1 (Cuti HRD) --
        LeaveService leaveService = new LeaveService();
        Employee emp1 = new Employee("E01", "Budi", 12);
        leaveService.addEmployee(emp1);
        leaveService.requestLeave(new LeaveRequest("E01", LocalDate.now(), LocalDate.now().plusDays(3)));
        
        List<String> onLeave = leaveService.getEmployeesOnLeave(LocalDate.now(), LocalDate.now().plusDays(5));
        System.out.println("Pegawai Cuti: " + onLeave);

        // -- Test US2, US3, US6 (Penerbangan) --
        FlightService flightService = new FlightService();
        Flight f1 = new Flight("F01", "JKT", "DPS", LocalDateTime.now().plusDays(1), new BigDecimal("1500000"), "Garuda");
        Flight f2 = new Flight("F02", "JKT", "DPS", LocalDateTime.now().plusDays(1), new BigDecimal("1000000"), "Lion Air");
        flightService.addFlight(f1);
        flightService.addFlight(f2);

        System.out.println("Penerbangan Termurah ke DPS: " + flightService.compareFlightsByPrice("DPS").get(0).airline());

        // -- Test US5 (Validasi Profil) --
        UserProfile profile = new UserProfile("U01");
        BookingService bookingService = new BookingService();
        try {
            bookingService.validateProfileAndTicket(profile);
        } catch (Exception e) {
            System.out.println("Error Validasi: " + e.getMessage());
        }
        
        // Lengkapi profil
        profile.updateProfile("Andi", "P123456");
        bookingService.validateProfileAndTicket(profile);
        System.out.println("Validasi profil berhasil!");

        // -- Test US7, US8, US9 (Booking Manajer) --
        Booking booking = bookingService.createBooking(f2, "Andi");
        System.out.println("Booking dibuat dengan Ref: " + booking.getReferenceCode());

        try {
            bookingService.authorizeBooking("SALAH-CODE");
        } catch (Exception e) {
            System.out.println("Otorisasi Gagal: " + e.getMessage());
        }

        bookingService.authorizeBooking(booking.getReferenceCode());
        System.out.println("Otorisasi Sukses. Status: " + booking.getStatus());
    }
}