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

    public String createOrUpdatePasswordResetTokenForUser(User user) {
        String otp = SecurityUtility.generateOtp();
        PasswordResetToken existingToken = tokenRepository.findByUser(user);
        if (existingToken != null) {
            existingToken.setOtp(otp);
            existingToken.setExpiryDate(existingToken.calculateExpiryDate());
            tokenRepository.save(existingToken);
        } else {
            PasswordResetToken newToken = new PasswordResetToken(otp, user);
            tokenRepository.save(newToken);
        }
        return otp;
    }

    public Optional<User> validateOtp(String otp) {
        PasswordResetToken resetToken = tokenRepository.findByOtp(otp);
        if (resetToken == null || resetToken.isExpired()) {
            return Optional.empty();
        }
        return Optional.of(resetToken.getUser());
    }

    // Additional methods as needed...
}
