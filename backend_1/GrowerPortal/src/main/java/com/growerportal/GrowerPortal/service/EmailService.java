package com.growerportal.GrowerPortal.service;

public interface EmailService {
    void sendVerificationEmail(String farmerEmail, String otp);

    String generateOtp();

    void notifySrTeam(String name, String email);
}
