package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.FieldHistory;
import com.growerportal.GrowerPortal.service.FieldHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field-histories")
public class FieldHistoryController {

    private final FieldHistoryService fieldHistoryService;

    @Autowired
    public FieldHistoryController(FieldHistoryService fieldHistoryService) {
        this.fieldHistoryService = fieldHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<FieldHistory>> getAllFieldHistories() {
        List<FieldHistory> fieldHistoryList = fieldHistoryService.getAllFieldHistories();
        return new ResponseEntity<>(fieldHistoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldHistory> getFieldHistoryById(@PathVariable Long id) {
        FieldHistory fieldHistory = fieldHistoryService.getFieldHistoryById(id);
        if (fieldHistory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fieldHistory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FieldHistory> createFieldHistory(@RequestBody FieldHistory fieldHistory) {
        FieldHistory createdFieldHistory = fieldHistoryService.createFieldHistory(fieldHistory);
        return new ResponseEntity<>(createdFieldHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FieldHistory> updateFieldHistory(@PathVariable Long id, @RequestBody FieldHistory fieldHistory) {
        FieldHistory updatedFieldHistory = fieldHistoryService.updateFieldHistory(id, fieldHistory);
        if (updatedFieldHistory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedFieldHistory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFieldHistory(@PathVariable Long id) {
        fieldHistoryService.deleteFieldHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

