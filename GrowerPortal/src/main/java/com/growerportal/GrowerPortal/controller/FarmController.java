package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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

    @GetMapping
    public ResponseEntity<List<AddApplicationDto.FarmDto>> getAllFarms() {
        List<AddApplicationDto.FarmDto> farmDtos = farmService.getAllFarms();
        return ResponseEntity.ok(farmDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplicationDto.FarmDto> getFarmById(@PathVariable Long id) {
        AddApplicationDto.FarmDto farmDto = farmService.getFarmById(id);
        return ResponseEntity.ok(farmDto);
    }

    @PostMapping
    public ResponseEntity<AddApplicationDto.FarmDto> createFarm(@RequestBody AddApplicationDto.FarmDto farmDto) {
        AddApplicationDto.FarmDto createdFarmDto = farmService.createFarm(farmDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFarmDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddApplicationDto.FarmDto> updateFarm(@PathVariable Long id, @RequestBody AddApplicationDto.FarmDto farmDto) {
        AddApplicationDto.FarmDto updatedFarmDto = farmService.updateFarm(id, farmDto);
        return ResponseEntity.ok(updatedFarmDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
        return ResponseEntity.noContent().build();
    }
}




