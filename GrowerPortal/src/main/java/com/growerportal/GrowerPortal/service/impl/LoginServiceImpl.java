package com.growerportal.GrowerPortal.service.impl;


import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    private final FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    @Autowired
    public LoginServiceImpl(FarmerPersonalInfoRepository farmerPersonalInfoRepository) {
        this.farmerPersonalInfoRepository = farmerPersonalInfoRepository;
    }

    @Override
    public boolean validateLogin(String email, String password) {
        return farmerPersonalInfoRepository.findByEmail(email)
                .map(farmer -> farmer.getPassword().equals(password))
                .orElse(false);
    }


}
