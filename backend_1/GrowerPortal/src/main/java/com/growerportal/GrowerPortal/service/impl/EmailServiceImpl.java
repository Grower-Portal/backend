package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${notification.srteam.emails}")
    private String[] recipients;

    public void sendVerificationEmail(String farmerEmail, String otp) {
        String htmlContent = buildOtpEmail(otp);
        this.sendEmail(farmerEmail, "Growers Portal - Verify Your Email", htmlContent);
    }

    private String buildOtpEmail(String otp) {
        try {
            Resource resource = resourceLoader.getResource("classpath:templates/otp-verification-email.html");
            String content = new String(Files.readAllBytes(Paths.get(resource.getURI())));
            return content.replace("{{ otp }}", otp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String generateOtp() {
        SecureRandom random = new SecureRandom();
        byte[] values = new byte[6]; // Number of bytes in the OTP
        random.nextBytes(values);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(values).substring(0, 6);
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


    @Override
    public void notifySrTeam(String name, String email) {
        String subject = "New Application Submission Received";
        Resource resource = resourceLoader.getResource("classpath:templates/notify-sr-email.html");
        String htmlContent;
        try {
            htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())), StandardCharsets.UTF_8);
            htmlContent = htmlContent

                    //Uncomment after frontend gives user current session details
//                    .replace("[Name]", name)
//                    .replace("[Email]", email)
                    .replace("[Date]", LocalDate.now().toString());
            sendEmail(Arrays.toString(recipients), subject, htmlContent);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load email template: " + e.getMessage());
        }
    }


}
