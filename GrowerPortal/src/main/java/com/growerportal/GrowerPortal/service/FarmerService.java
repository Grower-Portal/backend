package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.UserInfoDto;
import org.springframework.stereotype.Service;

@Service
public interface FarmerService {

    UserInfoDto  getUserInfo(String email);
}
