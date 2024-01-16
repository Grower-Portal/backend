package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.UserInfoDto;

public interface FarmerService {

    UserInfoDto  getUserInfo(String email);
}
