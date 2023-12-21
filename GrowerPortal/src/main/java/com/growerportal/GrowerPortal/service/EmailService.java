package com.growerportal.GrowerPortal.service;
// ... imports ...

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendOtpEmail(String to, String subject, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@yourcompany.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText("Your OTP for password reset is: " + otp);
        emailSender.send(message);
    }
}


