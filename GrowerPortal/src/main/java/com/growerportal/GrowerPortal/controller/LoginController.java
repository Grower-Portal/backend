package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.LoginDto;
import com.growerportal.GrowerPortal.dto.LoginResponseDTO;
import com.growerportal.GrowerPortal.service.impl.FarmerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private FarmerServiceImpl farmerService;

    @PostMapping("/login")
    public LoginResponseDTO loginUser(LoginDto body){
        return farmerService.loginUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(null, null, authentication);
            return ResponseEntity.ok("Logged out successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
