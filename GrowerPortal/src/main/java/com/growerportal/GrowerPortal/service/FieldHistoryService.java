package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.FieldHistory;
import com.growerportal.GrowerPortal.repository.FieldHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldHistoryService {

    private final FieldHistoryRepository fieldHistoryRepository;

    @Autowired
    public FieldHistoryService(FieldHistoryRepository fieldHistoryRepository) {
        this.fieldHistoryRepository = fieldHistoryRepository;
    }

    public List<FieldHistory> getAllFieldHistories() {
        return fieldHistoryRepository.findAll();
    }

    public FieldHistory getFieldHistoryById(Long id) {
        return fieldHistoryRepository.findById(id).orElse(null);
    }

    public FieldHistory createFieldHistory(FieldHistory fieldHistory) {
        return fieldHistoryRepository.save(fieldHistory);
    }

    public FieldHistory updateFieldHistory(Long id, FieldHistory fieldHistory) {
        FieldHistory existingFieldHistory = getFieldHistoryById(id);
        if (existingFieldHistory == null) {
            return null; // Handle not found case
        }

        // Update properties of existingFieldHistory with values from fieldHistory

        return fieldHistoryRepository.save(existingFieldHistory);
    }

    public void deleteFieldHistory(Long id) {
        fieldHistoryRepository.deleteById(id);
    }
}

