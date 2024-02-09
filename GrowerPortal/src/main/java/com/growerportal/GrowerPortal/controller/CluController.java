package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.service.CluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clus") // Define the base URL for clu-related endpoints
public class CluController {

    private final CluService cluService;

    @Autowired
    public CluController(CluService cluService) {
        this.cluService = cluService;
    }

    @GetMapping
    public ResponseEntity<List<AddApplicationDto.CluDto>> getAllClus() {
        List<AddApplicationDto.CluDto> clus = cluService.getAllClus();
        return ResponseEntity.ok(clus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplicationDto.CluDto> getCluById(@PathVariable Long id) {
        AddApplicationDto.CluDto clu = cluService.getCluById(id);
        return ResponseEntity.ok(clu);
    }

    @PostMapping
    public ResponseEntity<AddApplicationDto.CluDto> createClu(@RequestBody AddApplicationDto.CluDto cluDto) {
        AddApplicationDto.CluDto createdClu = cluService.createClu(cluDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddApplicationDto.CluDto> updateClu(@PathVariable Long id, @RequestBody AddApplicationDto.CluDto cluDto) {
        AddApplicationDto.CluDto updatedClu = cluService.updateClu(id, cluDto);
        return ResponseEntity.ok(updatedClu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClu(@PathVariable Long id) {
        cluService.deleteClu(id);
        return ResponseEntity.noContent().build();
    }
}

