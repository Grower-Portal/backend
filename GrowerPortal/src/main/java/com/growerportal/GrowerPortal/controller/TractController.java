package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.Tract;
import com.growerportal.GrowerPortal.service.TractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracts") // Define the base URL for tract-related endpoints
public class TractController {

    private final TractService tractService;

    @Autowired
    public TractController(TractService tractService) {
        this.tractService = tractService;
    }

    // Define endpoint for fetching a list of all tracts
    @GetMapping
    public ResponseEntity<List<Tract>> getAllTracts() {
        List<Tract> tracts = tractService.getAllTracts();
        return ResponseEntity.ok(tracts);
    }

    // Define endpoint for fetching a specific tract by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tract> getTractById(@PathVariable Long id) {
        Tract tract = tractService.getTractById(id);
        return ResponseEntity.ok(tract);
    }

    // Define endpoint for creating a new tract
    @PostMapping
    public ResponseEntity<Tract> createTract(@RequestBody Tract tract) {
        Tract createdTract = tractService.createTract(tract);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTract);
    }

    // Define endpoint for updating an existing tract
    @PutMapping("/{id}")
    public ResponseEntity<Tract> updateTract(@PathVariable Long id, @RequestBody Tract tract) {
        Tract updatedTract = tractService.updateTract(id, tract);
        return ResponseEntity.ok(updatedTract);
    }

    // Define endpoint for deleting a tract by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTract(@PathVariable Long id) {
        tractService.deleteTract(id);
        return ResponseEntity.noContent().build();
    }
}


