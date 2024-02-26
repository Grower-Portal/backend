package com.growerportal.GrowerPortal.service.impl;


import com.growerportal.GrowerPortal.dto.FarmerSignupDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.VerificationToken;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.repository.VerificationTokenRepository;
import com.growerportal.GrowerPortal.service.FarmerSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class FarmerSignupServiceImpl implements FarmerSignupService {

    private final FarmerPersonalInfoRepository farmerRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public FarmerSignupServiceImpl(FarmerPersonalInfoRepository farmerRepository, VerificationTokenRepository verificationTokenRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.farmerRepository = farmerRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public FarmerPersonalInfo register(FarmerSignupDto signupDto) {
        FarmerPersonalInfo farmer = new FarmerPersonalInfo();
        farmer.setFirstName(signupDto.getFirstName());
        farmer.setMiddleName(signupDto.getMiddleName());
        farmer.setLastName(signupDto.getLastName());
        farmer.setSuffix(signupDto.getSuffix());
        farmer.setDob(signupDto.getDateOfBirth());
        farmer.setEmail(signupDto.getEmail());
        String encryptedPassword = bCryptPasswordEncoder.encode(signupDto.getPassword());
        signupDto.setPassword(encryptedPassword);
        farmer.setPassword(signupDto.getPassword());
        farmer.setPhoneNumber(signupDto.getPhoneNumber());
        farmer.setAddress(signupDto.getAddress());

        return farmerRepository.save(farmer);
    }

    public boolean emailExists(String email) {
        return farmerRepository.findByEmail(email).isPresent();
    }

    public void saveOrUpdateOtpForEmail(String email, String otp) {
        VerificationToken token;
        token = new VerificationToken();

        Optional<VerificationToken> tokenOptional = verificationTokenRepository.findTokenByEmail(email);
//        VerificationToken token;
        if (tokenOptional.isPresent()) {
            // If an entry exists, update it with the new OTP and expiry date.
            token = tokenOptional.get();
            token.setToken(otp);
        } else {
            // If no entry exists, create a new one.
            token = new VerificationToken();
            token.setEmail(email);
            token.setToken(otp);
        }
        token.setExpiryDate(Instant.now().plus(30, ChronoUnit.MINUTES));
        verificationTokenRepository.save(token);
    }



    public boolean verifyOtpForEmail(String email, String otp) {
        Optional<VerificationToken> verificationTokenOptional = verificationTokenRepository.findTokenByEmail(email);
        if (verificationTokenOptional.isPresent()) {
            VerificationToken verificationToken = verificationTokenOptional.get();
            return verificationToken.getToken().equals(otp) && verificationToken.getExpiryDate().isAfter(Instant.now());
        }
        return false;

    }

    public void saveFarmer(FarmerPersonalInfo farmer) {
        farmerRepository.save(farmer);
    }
}
