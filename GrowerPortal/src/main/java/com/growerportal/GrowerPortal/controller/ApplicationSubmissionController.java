package com.growerportal.GrowerPortal.controller;


import com.growerportal.GrowerPortal.dto.ApplicationDto;
import com.growerportal.GrowerPortal.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application-form")
public class ApplicationSubmissionController {

    private final EmailService emailServiceImpl;

    public ApplicationSubmissionController(EmailService emailServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
    }


    @PostMapping("/submit")
    public ResponseEntity<?> submitApplication(@RequestBody ApplicationDto applicationDto) {

        // Logic for Add Application goes here

//            emailServiceImpl.notifySrTeam(applicationDto.getProducerName(), "");
            return ResponseEntity.ok("Application submitted successfully for approval");
    }

}
