package com.growerportal.GrowerPortal.dto;

public class PasswordDto {

    private String newPassword;
    private String confirmPassword;

    // Default constructor
    public PasswordDto() {
    }

    // Constructor with parameters
    public PasswordDto(String newPassword, String confirmPassword) {
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    // Getter and setter for newPassword
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    // Getter and setter for confirmPassword
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
