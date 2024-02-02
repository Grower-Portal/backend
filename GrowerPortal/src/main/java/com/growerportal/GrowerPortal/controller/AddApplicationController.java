package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.AddApplication;
import com.growerportal.GrowerPortal.service.AddApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class AddApplicationController {

    @Autowired
    private AddApplicationService addApplicationService;

    @GetMapping
    public ResponseEntity<List<AddApplication>> getAllApplications() {
        List<AddApplication> applications = addApplicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplication> getApplicationById(@PathVariable Long id) {
        Optional<AddApplication> application = addApplicationService.getApplicationById(id);
        return application.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddApplication> createApplication(@RequestBody AddApplication application) {
        AddApplication createdApplication = addApplicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddApplication> updateApplication(@PathVariable Long id, @RequestBody AddApplication application) {
        addApplicationService.updateApplication(id, application);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        addApplicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}

