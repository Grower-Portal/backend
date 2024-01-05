package com.growerportal.GrowerPortal.service;

// ... other imports ...
import com.growerportal.GrowerPortal.entity.PasswordResetToken;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private TemplateEngine templateEngine; // Autowire the Thymeleaf template engine
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);


    public void sendVerificationEmail(String farmerEmail, String otp) {

    }

    public String generateOtp() {
        return null;
    }

    public void notifySrTeam(String name, String email) {

    }

    public void sendOtpEmail(String to, String subject, String otp) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            Context context = new Context();
            context.setVariable("otp", otp); // Set variables in the context

            String html = templateEngine.process("email/passwordResetEmailTemplate", context); // Process the template

            helper.setFrom("noreply@yourcompany.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true); // Set to true for HTML content

            emailSender.send(message);
        } catch (MessagingException e) {
            logger.error("Error sending OTP email", e);
            // Optionally, you can rethrow the exception or handle it based on your business logic
            // throw new EmailSendingException("Failed to send OTP email", e); // Custom exception
        } catch (Exception e) {
            logger.error("An unexpected error occurred when sending the email", e);
            // Handle other unexpected exceptions
        }
    }
}
