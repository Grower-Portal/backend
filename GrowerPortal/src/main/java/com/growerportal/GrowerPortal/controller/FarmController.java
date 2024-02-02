package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.Farm;
import com.growerportal.GrowerPortal.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms") // Define the base URL for farm-related endpoints
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // Define endpoint for fetching a list of all farms
    @GetMapping
    public ResponseEntity<List<Farm>> getAllFarms() {
        List<Farm> farms = farmService.getAllFarms();
        return ResponseEntity.ok(farms);
    }

    // Define endpoint for fetching a specific farm by ID
    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarmById(@PathVariable Long id) {
        Farm farm = farmService.getFarmById(id);
        return ResponseEntity.ok(farm);
    }

    // Define endpoint for creating a new farm
    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
        Farm createdFarm = farmService.createFarm(farm);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFarm);
    }

    // Define endpoint for updating an existing farm
    @PutMapping("/{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable Long id, @RequestBody Farm farm) {
        Farm updatedFarm = farmService.updateFarm(id, farm);
        return ResponseEntity.ok(updatedFarm);
    }

    // Define endpoint for deleting a farm by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
        return ResponseEntity.noContent().build();
    }
}




