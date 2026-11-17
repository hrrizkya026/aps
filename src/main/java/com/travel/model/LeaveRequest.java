package com.travel.model;

import java.time.LocalDate;

public record LeaveRequest(String employeeId, LocalDate startDate, LocalDate endDate) {
}