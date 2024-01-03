package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.Dto.ApplicationDto;
import com.growerportal.GrowerPortal.entity.Application;
import com.growerportal.GrowerPortal.repository.ApplicationRepository;
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
    private final ApplicationRepository applicationRepository;

    // Inject the EmailService and ApplicationRepository through constructor injection
    public ApplicationSubmissionController(EmailService emailServiceImpl, ApplicationRepository applicationRepository) {
        this.emailServiceImpl = emailServiceImpl;
        this.applicationRepository = applicationRepository;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitApplication(@RequestBody ApplicationDto applicationDto) {
        try {
            // Convert the DTO to an entity (assuming you have a converter method or a constructor in Application entity)
            Application application = convertDtoToEntity(applicationDto);

            // Save the application data to the database
            applicationRepository.save(application);

            // Notify the Senior Team using the email service
            emailServiceImpl.notifySrTeam(applicationDto.getProducerName(), "");

            return ResponseEntity.ok("Application submitted successfully for approval");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to submit application: " + e.getMessage());
        }
    }

    private Application convertDtoToEntity(ApplicationDto applicationDto) {
        // Implement logic to convert ApplicationDto to Application entity
        // You can use a mapper library or manually set the values
        Application application = new Application();
        application.setProducerName(applicationDto.getProducerName());
        application.setProducerName(applicationDto.getApplicationDetails());
        // Set other fields as needed

        return application;
    }
}
