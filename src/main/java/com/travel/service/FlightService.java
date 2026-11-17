package com.travel.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.travel.model.Flight;

public class FlightService {
    private final List<Flight> availableFlights = new ArrayList<>();

    public void addFlight(Flight flight) { availableFlights.add(flight); }

    // US2 & US3: Mencari berdasarkan tujuan
    public List<Flight> searchFlights(String destination) {
        return availableFlights.stream()
                .filter(f -> f.destination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }

    // US6: Membandingkan berdasarkan harga termurah
    public List<Flight> compareFlightsByPrice(String destination) {
        return searchFlights(destination).stream()
                .sorted(Comparator.comparing(Flight::price))
                .collect(Collectors.toList());
    }
}