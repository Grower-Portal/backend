package com.growerportal.GrowerPortal.service;

import java.util.Map;

import com.growerportal.GrowerPortal.Dto.UserInfoDto;

public interface FarmerService {

    UserInfoDto  getUserInfo(String email);
    
    Map<String, Double> getAutoPopulatedFields(Long farmerId);

}
