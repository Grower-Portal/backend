package com.growerportal.GrowerPortal.service.impl;


import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    private final FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginServiceImpl(FarmerPersonalInfoRepository farmerPersonalInfoRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.farmerPersonalInfoRepository = farmerPersonalInfoRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean validateLogin(String email, String password) {
        return farmerPersonalInfoRepository.findByEmail(email)
                .map(farmer -> bCryptPasswordEncoder.matches(password, farmer.getPassword()))
                .orElse(false);
    }

}
