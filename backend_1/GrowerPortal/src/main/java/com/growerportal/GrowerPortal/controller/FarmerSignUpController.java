package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.Dto.FarmerSignupDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.service.EmailService;
import com.growerportal.GrowerPortal.service.FarmerSignupService;
import com.growerportal.GrowerPortal.service.impl.EmailServiceImpl;
import com.growerportal.GrowerPortal.service.impl.FarmerSignupServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// Other imports

@RestController
@RequestMapping("/api/farmers")
public class FarmerSignUpController {


    private final FarmerSignupService signupService;
    private final EmailService emailServiceImpl;

    public FarmerSignUpController(FarmerSignupServiceImpl signupService, EmailServiceImpl emailServiceImpl) {
        this.signupService = signupService;
        this.emailServiceImpl = emailServiceImpl;
    }

    @PostMapping("/send-verification-code")
    public ResponseEntity<?> sendVerificationCode(@RequestParam String email) {
        // Generate OTP and send email logic
        String otp = emailServiceImpl.generateOtp();
        emailServiceImpl.sendVerificationEmail(email, otp);
        // Store the OTP with a timestamp in the database linked to the user's email
        signupService.saveOtpForEmail(email, otp);
        return ResponseEntity.ok("Verification code sent to email.");
    }

    // Method to verify OTP and save farmer details
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtpAndRegisterFarmer(@RequestParam String email, @RequestParam String otp, @RequestBody FarmerSignupDto signupDto) {
        boolean isOtpValid = signupService.verifyOtpForEmail(email, otp);
        if (!isOtpValid) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP.");
        }

        FarmerPersonalInfo farmer = signupService.register(signupDto);
        if (farmer == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed");
        }

        // Save farmer to database
        signupService.saveFarmer(farmer);
        return ResponseEntity.ok("Farmer registered successfully and email verified.");
    }
}
