package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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

    @GetMapping
    public ResponseEntity<List<AddApplicationDto.FieldNameDto>> getAllFieldNames() {
        List<AddApplicationDto.FieldNameDto> fieldNames = fieldNameService.getAllFieldNames();
        return ResponseEntity.ok(fieldNames);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplicationDto.FieldNameDto> getFieldNameById(@PathVariable Long id) {
        AddApplicationDto.FieldNameDto fieldName = fieldNameService.getFieldNameById(id);
        return ResponseEntity.ok(fieldName);
    }

    @PostMapping
    public ResponseEntity<AddApplicationDto.FieldNameDto> createFieldName(@RequestBody AddApplicationDto.FieldNameDto fieldNameDto) {
        AddApplicationDto.FieldNameDto createdFieldName = fieldNameService.createFieldName(fieldNameDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFieldName);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddApplicationDto.FieldNameDto> updateFieldName(@PathVariable Long id, @RequestBody AddApplicationDto.FieldNameDto fieldNameDto) {
        AddApplicationDto.FieldNameDto updatedFieldName = fieldNameService.updateFieldName(id, fieldNameDto);
        return ResponseEntity.ok(updatedFieldName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFieldName(@PathVariable Long id) {
        fieldNameService.deleteFieldName(id);
        return ResponseEntity.noContent().build();
    }
}

