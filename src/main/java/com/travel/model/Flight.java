package com.travel.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Flight(String flightId, String origin, String destination, 
                     LocalDateTime departureTime, BigDecimal price, String airline) {
}