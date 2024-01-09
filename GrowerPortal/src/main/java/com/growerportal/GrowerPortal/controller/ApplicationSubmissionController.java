package com.growerportal.GrowerPortal.controller;


import com.growerportal.GrowerPortal.Dto.ApplicationDto;
import com.growerportal.GrowerPortal.service.EmailService;
import com.growerportal.GrowerPortal.service.FarmerService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application-form")
public class ApplicationSubmissionController {

    private final EmailService emailServiceImpl;
    
    private final FarmerService farmerServiceImpl;


    public ApplicationSubmissionController(EmailService emailServiceImpl, FarmerService farmerServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
        this.farmerServiceImpl = farmerServiceImpl;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitApplication(@RequestBody ApplicationDto applicationDto) {

        // Logic for Add Application goes here

            emailServiceImpl.notifySrTeam(applicationDto.getProducerName(), "");
            return ResponseEntity.ok("Application submitted successfully for approval");
    }
    

    @GetMapping("/uniqueFramIdsAndSumOfRptQty")
    public Map<String, Double> getUniqueFramIdsAndSumOfRptQty(@RequestParam Long farmerId) {
        return farmerServiceImpl.getAutoPopulatedFields(farmerId);
    }

}
