package com.growerportal.GrowerPortal.controller;


import com.growerportal.GrowerPortal.Dto.LoginDto;
import com.growerportal.GrowerPortal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping("/api/auth")
    public class LoginController {

        private final LoginService loginService;

        @Autowired
        public LoginController(LoginService loginService) {
            this.loginService = loginService;
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
            boolean isValidUser = loginService.validateLogin(loginDto.getUsername(), loginDto.getPassword());
            if (!isValidUser) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
            // Logic to generate and return a token (e.g., JWT) goes here
            return ResponseEntity.ok("User authenticated successfully");
        }



}
