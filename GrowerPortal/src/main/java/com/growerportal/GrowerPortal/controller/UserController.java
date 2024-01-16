package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.UserInfoDto;
import com.growerportal.GrowerPortal.service.FarmerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final FarmerService farmerService;

    public UserController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }


    @GetMapping("/info")
    public ResponseEntity<UserInfoDto> getUserInfo(@RequestParam String email) {
        UserInfoDto userInfo = farmerService.getUserInfo(email);
        return ResponseEntity.ok(userInfo);
    }
}
