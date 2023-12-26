package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String farmerEmail, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(farmerEmail);
        message.setSubject("Growers Portal - Verify Your Email");
        message.setText("Your OTP for email verification is: " + otp);
        mailSender.send(message);
    }

    public String generateOtp() {
        SecureRandom random = new SecureRandom();
        byte[] values = new byte[6]; // Number of bytes in the OTP
        random.nextBytes(values);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(values).substring(0, 6);
    }
}
