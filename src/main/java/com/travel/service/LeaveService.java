package com.travel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.travel.model.Employee;
import com.travel.model.LeaveRequest;

public class LeaveService {
    private final List<Employee> employees = new ArrayList<>();
    private final List<LeaveRequest> leaveRequests = new ArrayList<>();

    public void addEmployee(Employee employee) { employees.add(employee); }
    public void requestLeave(LeaveRequest request) { leaveRequests.add(request); }

    // US1: Melihat pegawai yang cuti berdasarkan periode
    public List<String> getEmployeesOnLeave(LocalDate start, LocalDate end) {
        return leaveRequests.stream()
                .filter(req -> !req.endDate().isBefore(start) && !req.startDate().isAfter(end))
                .map(req -> {
                    Employee emp = employees.stream()
                            .filter(e -> e.getId().equals(req.employeeId()))
                            .findFirst().orElseThrow();
                    return emp.getName() + " (Cuti: " + req.startDate() + " s/d " + req.endDate() + ")";
                })
                .collect(Collectors.toList());
    }
}