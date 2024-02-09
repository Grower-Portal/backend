package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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
    public ResponseEntity<List<AddApplicationDto>> getAllApplications() {
        List<AddApplicationDto> applicationDtos = addApplicationService.getAllApplications();
        return ResponseEntity.ok(applicationDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplicationDto> getApplicationById(@PathVariable Long id) {
        Optional<AddApplicationDto> applicationDto = addApplicationService.getApplicationById(id);
        return applicationDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddApplicationDto> createApplication(@RequestBody AddApplicationDto applicationDto) {
        AddApplicationDto createdApplication = addApplicationService.createApplication(applicationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateApplication(@PathVariable Long id, @RequestBody AddApplicationDto applicationDto) {
        addApplicationService.updateApplication(id, applicationDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        addApplicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}

