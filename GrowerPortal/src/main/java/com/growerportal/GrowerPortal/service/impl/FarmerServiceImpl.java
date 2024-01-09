package com.growerportal.GrowerPortal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.growerportal.GrowerPortal.Dto.UserInfoDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.repository.FarmerRequestForApprovalRepository;
import com.growerportal.GrowerPortal.service.FarmerService;

@Service
public class FarmerServiceImpl implements FarmerService {


    private final FarmerPersonalInfoRepository farmerPersonalInfoRepository;
    
    private final FarmerRequestForApprovalRepository farmerRequestRepository;

    public FarmerServiceImpl(FarmerPersonalInfoRepository farmerPersonalInfoRepository, FarmerRequestForApprovalRepository farmerRequestRepository) {
        this.farmerPersonalInfoRepository = farmerPersonalInfoRepository;
		this.farmerRequestRepository = farmerRequestRepository;
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
    

    public Map<String, Double> getAutoPopulatedFields(Long farmerId) {
        List<Object[]> results = farmerRequestRepository.getAutoPopulatedFields(farmerId);

        Map<String, Double> uniqueFramIds = new HashMap<>();
        for (Object[] result : results) {
            String framId = (String) result[0];
            Double sumRptQty = (Double) result[1];
            uniqueFramIds.put(framId, sumRptQty);
        }

        return uniqueFramIds;
    }
}
