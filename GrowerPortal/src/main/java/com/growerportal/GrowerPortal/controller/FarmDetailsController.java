package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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
    public ResponseEntity<List<AddApplicationDto.FarmDetailsDto>> getAllFarmDetails() {
        List<AddApplicationDto.FarmDetailsDto> farmDetailsList = farmDetailsService.getAllFarmDetails();
        return new ResponseEntity<>(farmDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplicationDto.FarmDetailsDto> getFarmDetailsById(@PathVariable Long id) {
        AddApplicationDto.FarmDetailsDto farmDetails = farmDetailsService.getFarmDetailsDtoById(id);
        if (farmDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(farmDetails, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddApplicationDto.FarmDetailsDto> createFarmDetails(@RequestBody AddApplicationDto.FarmDetailsDto farmDetailsDto) {
        AddApplicationDto.FarmDetailsDto createdFarmDetails = farmDetailsService.createFarmDetailsDto(farmDetailsDto);
        return new ResponseEntity<>(createdFarmDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddApplicationDto.FarmDetailsDto> updateFarmDetails(@PathVariable Long id, @RequestBody AddApplicationDto.FarmDetailsDto farmDetailsDto) {
        AddApplicationDto.FarmDetailsDto updatedFarmDetails = farmDetailsService.updateFarmDetailsDto(id, farmDetailsDto);
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

