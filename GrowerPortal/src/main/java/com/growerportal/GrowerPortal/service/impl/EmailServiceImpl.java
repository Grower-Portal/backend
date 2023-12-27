package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendVerificationEmail(String farmerEmail, String otp) {
        String htmlContent = buildOtpEmail(otp);
        this.sendEmail(farmerEmail, "Growers Portal - Verify Your Email", htmlContent);
    }

    public String generateOtp() {
        SecureRandom random = new SecureRandom();
        byte[] values = new byte[6]; // Number of bytes in the OTP
        random.nextBytes(values);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(values).substring(0, 6);
    }

    public String buildOtpEmail(String otp) {
        return "<html>" +
                "<body>" +
                "<h1>Growers Portal - Email Verification</h1>" +
                "<p>Your OTP for email verification is:</p>" +
                "<h2 style='color: blue;'>" + otp + "</h2>" +
                "<p>Please use this code to complete your registration.</p>" +
                "</body>" +
                "</html>";
    }

    public void sendEmail(String to, String subject, String htmlContent) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // Set to 'true' to enable HTML content
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }


}
