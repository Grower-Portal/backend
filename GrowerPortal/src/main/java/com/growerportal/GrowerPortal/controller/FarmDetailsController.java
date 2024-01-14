package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.FarmDetails;
import com.growerportal.GrowerPortal.service.FarmDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farm-details")
public class FarmDetailsController {

    private final FarmDetailsService farmDetailsService;

    @Autowired
    public FarmDetailsController(FarmDetailsService farmDetailsService) {
        this.farmDetailsService = farmDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<FarmDetails>> getAllFarmDetails() {
        List<FarmDetails> farmDetailsList = farmDetailsService.getAllFarmDetails();
        return new ResponseEntity<>(farmDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmDetails> getFarmDetailsById(@PathVariable Long id) {
        FarmDetails farmDetails = farmDetailsService.getFarmDetailsById(id);
        if (farmDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(farmDetails, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FarmDetails> createFarmDetails(@RequestBody FarmDetails farmDetails) {
        FarmDetails createdFarmDetails = farmDetailsService.createFarmDetails(farmDetails);
        return new ResponseEntity<>(createdFarmDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmDetails> updateFarmDetails(@PathVariable Long id, @RequestBody FarmDetails farmDetails) {
        FarmDetails updatedFarmDetails = farmDetailsService.updateFarmDetails(id, farmDetails);
        if (updatedFarmDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedFarmDetails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmDetails(@PathVariable Long id) {
        farmDetailsService.deleteFarmDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

