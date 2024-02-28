package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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

    @GetMapping
    public ResponseEntity<List<AddApplicationDto.TractDto>> getAllTracts() {
        List<AddApplicationDto.TractDto> tractDtos = tractService.getAllTracts();
        return ResponseEntity.ok(tractDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplicationDto.TractDto> getTractById(@PathVariable Long id) {
        AddApplicationDto.TractDto tractDto = tractService.getTractById(id);
        return ResponseEntity.ok(tractDto);
    }

    @PostMapping
    public ResponseEntity<AddApplicationDto.TractDto> createTract(@RequestBody AddApplicationDto.TractDto tractDto) {
        AddApplicationDto.TractDto createdTractDto = tractService.createTract(tractDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTractDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddApplicationDto.TractDto> updateTract(@PathVariable Long id, @RequestBody AddApplicationDto.TractDto tractDto) {
        AddApplicationDto.TractDto updatedTractDto = tractService.updateTract(id, tractDto);
        return ResponseEntity.ok(updatedTractDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTract(@PathVariable Long id) {
        tractService.deleteTract(id);
        return ResponseEntity.noContent().build();
    }
}


