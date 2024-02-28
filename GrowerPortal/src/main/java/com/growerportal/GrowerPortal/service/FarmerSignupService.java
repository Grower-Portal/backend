package com.growerportal.GrowerPortal.service;


import com.growerportal.GrowerPortal.dto.FarmerSignupDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;

public interface FarmerSignupService {

    FarmerPersonalInfo register(FarmerSignupDto signupDto);

    void saveOrUpdateOtpForEmail(String email, String otp);

    boolean verifyOtpForEmail(String email, String otp);

    void saveFarmer(FarmerPersonalInfo farmer);

    boolean emailExists(String email);
}
