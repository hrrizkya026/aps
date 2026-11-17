package com.travel.model;

public class UserProfile {
    private final String userId;
    private String fullName;
    private String passportNumber;
    private boolean isComplete;

    public UserProfile(String userId) {
        this.userId = userId;
        this.isComplete = false; 
    }

    public void updateProfile(String fullName, String passportNumber) {
        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.isComplete = (fullName != null && !fullName.isBlank() && passportNumber != null);
    }

    public boolean isComplete() { return isComplete; }
}