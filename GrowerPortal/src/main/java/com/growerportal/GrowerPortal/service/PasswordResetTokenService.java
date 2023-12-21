package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.PasswordResetToken;
import com.growerportal.GrowerPortal.entity.User;
import com.growerportal.GrowerPortal.repository.PasswordResetTokenRepository;
import com.growerportal.GrowerPortal.util.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordResetTokenService {

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    public PasswordResetToken createPasswordResetTokenForUser(User user) {
        String otp = SecurityUtility.generateOtp();
        PasswordResetToken resetToken = new PasswordResetToken(otp, user);
        return tokenRepository.save(resetToken);
    }

    public Optional<User> validateOtp(String otp) {
        PasswordResetToken resetToken = tokenRepository.findByOtp(otp);
        if (resetToken == null || resetToken.isExpired()) {
            return Optional.empty(); // Returns an empty Optional to indicate no valid user was found
        }
        return Optional.of(resetToken.getUser()); // Returns the user associated with the valid OTP
    }

    // Other methods...
}

