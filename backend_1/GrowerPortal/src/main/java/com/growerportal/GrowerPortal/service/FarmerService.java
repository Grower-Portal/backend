package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.Dto.UserInfoDto;

public interface FarmerService {

    UserInfoDto  getUserInfo(String email);
}
