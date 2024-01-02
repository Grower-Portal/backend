package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.Dto.FarmerSignupDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.Roles;
import com.growerportal.GrowerPortal.entity.VerificationToken;
import com.growerportal.GrowerPortal.enums.ERole;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.repository.RolesRepository;
import com.growerportal.GrowerPortal.repository.VerificationTokenRepository;
import com.growerportal.GrowerPortal.service.FarmerSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FarmerSignupServiceImpl implements FarmerSignupService {

    private final FarmerPersonalInfoRepository farmerRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RolesRepository rolesRepository;

    @Autowired
    public FarmerSignupServiceImpl(FarmerPersonalInfoRepository farmerRepository, VerificationTokenRepository verificationTokenRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RolesRepository rolesRepository) {
        this.farmerRepository = farmerRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.rolesRepository = rolesRepository;
    }

    public FarmerPersonalInfo register(FarmerSignupDto signupDto) {
        FarmerPersonalInfo farmer = new FarmerPersonalInfo();
        farmer.setFirstName(signupDto.getFirstName());
        farmer.setLastName(signupDto.getLastName());
        farmer.setDob(signupDto.getDateOfBirth());
        farmer.setUsername(signupDto.getUsername());
        String encryptedPassword = bCryptPasswordEncoder.encode(signupDto.getPassword());
        signupDto.setPassword(encryptedPassword);
        farmer.setPassword(signupDto.getPassword());
        farmer.setEmail(signupDto.getEmail());
        farmer.setAddress(signupDto.getAddress());
        Set<Roles> roles = getRoles();
        farmer.setRoles(roles);
        return farmerRepository.save(farmer);
    }

    private Set<Roles> getRoles() {
        Set<Roles> roles = new HashSet<>();
        Roles userRole = rolesRepository.findByName(ERole.ROLE_FARMER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        return roles;
    }

    public void saveOtpForEmail(String email, String otp) {
        VerificationToken token = new VerificationToken();
        token.setToken(otp);
        token.setExpiryDate(Instant.now().plus(30, ChronoUnit.MINUTES));
        token.setEmail(email);
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
