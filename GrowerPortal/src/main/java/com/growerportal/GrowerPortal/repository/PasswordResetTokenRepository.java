package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByOtp(String otp);
    PasswordResetToken findByUser(FarmerPersonalInfo user);
}
