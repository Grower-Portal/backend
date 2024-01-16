package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.dto.UserInfoDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.service.FarmerService;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImpl implements FarmerService {


    private final FarmerPersonalInfoRepository farmerPersonalInfoRepository;


    public FarmerServiceImpl(FarmerPersonalInfoRepository farmerPersonalInfoRepository) {
        this.farmerPersonalInfoRepository = farmerPersonalInfoRepository;
    }

    public UserInfoDto getUserInfo(String email) {
        FarmerPersonalInfo farmer = farmerPersonalInfoRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("No user found with email: " + email));

        UserInfoDto userInfoDTO = new UserInfoDto();
        userInfoDTO.setName(farmer.getFirstName() + " " + farmer.getLastName());
        userInfoDTO.setEmail(farmer.getEmail());
        userInfoDTO.setPhone(farmer.getPhoneNumber());
        userInfoDTO.setAddress(farmer.getAddress());
        userInfoDTO.setDob(farmer.getDob());

        return userInfoDTO;
    }
}
