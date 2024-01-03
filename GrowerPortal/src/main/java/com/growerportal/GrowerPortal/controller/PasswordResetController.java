package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.PasswordDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.repository.UserRepository;
import com.growerportal.GrowerPortal.service.EmailService;
import com.growerportal.GrowerPortal.service.PasswordResetTokenService;
import com.growerportal.GrowerPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class PasswordResetController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenService tokenService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @PostMapping("/request-password-reset")
    public ResponseEntity<?> requestPasswordReset(@RequestParam("email") String email) {
        Optional<FarmerPersonalInfo> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("User with given email doesn't exist");
        }

        FarmerPersonalInfo user = userOptional.get();
        String otp = tokenService.createOrUpdatePasswordResetTokenForUser(user);

        emailService.sendOtpEmail(email, "Password Reset OTP", otp);
        return ResponseEntity.ok().body("OTP sent to email");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam("otp") String otp,
                                           @RequestBody PasswordDto passwordDto) {
        Optional<FarmerPersonalInfo> userOptional = tokenService.validateOtp(otp);
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid or expired OTP");
        }

        FarmerPersonalInfo user = userOptional.get();

        if (!isValidPassword(passwordDto.getNewPassword())) {
            return ResponseEntity.badRequest().body("Invalid password format");
        }

        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match");
        }

        userService.updatePassword(user, passwordDto.getNewPassword());
        return ResponseEntity.ok().body("Password updated successfully");
    }

    private boolean isValidPassword(String password) {
        // Implement your password policy here
        // Example: check password length, uppercase, lowercase, numbers, symbols, etc.
        return password.length() >= 5; // Simple length check example
    }
}
