package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.Clu;
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

    // Define endpoint for fetching a list of all clus
    @GetMapping
    public ResponseEntity<List<Clu>> getAllClus() {
        List<Clu> clus = cluService.getAllClus();
        return ResponseEntity.ok(clus);
    }

    // Define endpoint for fetching a specific clu by ID
    @GetMapping("/{id}")
    public ResponseEntity<Clu> getCluById(@PathVariable Long id) {
        Clu clu = cluService.getCluById(id);
        return ResponseEntity.ok(clu);
    }

    // Define endpoint for creating a new clu
    @PostMapping
    public ResponseEntity<Clu> createClu(@RequestBody Clu clu) {
        Clu createdClu = cluService.createClu(clu);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClu);
    }

    // Define endpoint for updating an existing clu
    @PutMapping("/{id}")
    public ResponseEntity<Clu> updateClu(@PathVariable Long id, @RequestBody Clu clu) {
        Clu updatedClu = cluService.updateClu(id, clu);
        return ResponseEntity.ok(updatedClu);
    }

    // Define endpoint for deleting a clu by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClu(@PathVariable Long id) {
        cluService.deleteClu(id);
        return ResponseEntity.noContent().build();
    }
}

