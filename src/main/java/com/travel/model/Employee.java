package com.travel.model;

public class Employee {
    private final String id;
    private final String name;
    private final int remainingLeaveDays;

    public Employee(String id, String name, int remainingLeaveDays) {
        this.id = id;
        this.name = name;
        this.remainingLeaveDays = remainingLeaveDays;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getRemainingLeaveDays() { return remainingLeaveDays; }
}