package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.FieldName;
import com.growerportal.GrowerPortal.service.FieldNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fieldnames") // Define the base URL for fieldname-related endpoints
public class FieldNameController {

    private final FieldNameService fieldNameService;

    @Autowired
    public FieldNameController(FieldNameService fieldNameService) {
        this.fieldNameService = fieldNameService;
    }

    // Define endpoint for fetching a list of all fieldnames
    @GetMapping
    public ResponseEntity<List<FieldName>> getAllFieldNames() {
        List<FieldName> fieldNames = fieldNameService.getAllFieldNames();
        return ResponseEntity.ok(fieldNames);
    }

    // Define endpoint for fetching a specific fieldname by ID
    @GetMapping("/{id}")
    public ResponseEntity<FieldName> getFieldNameById(@PathVariable Long id) {
        FieldName fieldName = fieldNameService.getFieldNameById(id);
        return ResponseEntity.ok(fieldName);
    }

    // Define endpoint for creating a new fieldname
    @PostMapping
    public ResponseEntity<FieldName> createFieldName(@RequestBody FieldName fieldName) {
        FieldName createdFieldName = fieldNameService.createFieldName(fieldName);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFieldName);
    }

    // Define endpoint for updating an existing fieldname
    @PutMapping("/{id}")
    public ResponseEntity<FieldName> updateFieldName(@PathVariable Long id, @RequestBody FieldName fieldName) {
        FieldName updatedFieldName = fieldNameService.updateFieldName(id, fieldName);
        return ResponseEntity.ok(updatedFieldName);
    }

    // Define endpoint for deleting a fieldname by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFieldName(@PathVariable Long id) {
        fieldNameService.deleteFieldName(id);
        return ResponseEntity.noContent().build();
    }
}

