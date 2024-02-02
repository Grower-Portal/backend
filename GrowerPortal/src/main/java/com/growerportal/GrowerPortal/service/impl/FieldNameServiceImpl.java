package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.entity.FieldName;
import com.growerportal.GrowerPortal.entity.Clu;
import com.growerportal.GrowerPortal.repository.FieldNameRepository;
import com.growerportal.GrowerPortal.service.FieldNameService;
import com.growerportal.GrowerPortal.util.FieldNameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldNameServiceImpl implements FieldNameService {

    private final FieldNameRepository fieldNameRepository;

    @Autowired
    public FieldNameServiceImpl(FieldNameRepository fieldNameRepository) {
        this.fieldNameRepository = fieldNameRepository;
    }

    @Override
    public List<FieldName> getAllFieldNames() {
        return fieldNameRepository.findAll();
    }

    @Override
    public FieldName getFieldNameById(Long id) {
        return fieldNameRepository.findById(id)
                .orElseThrow(() -> new FieldNameNotFoundException(id));
    }

    @Override
    public FieldName createFieldName(FieldName fieldName) {
        // Calculate and set reportQtyAcres based on associated clus
//        calculateReportQtyAcres(fieldName);
        return fieldNameRepository.save(fieldName);
    }

    @Override
    public FieldName updateFieldName(Long id, FieldName fieldName) {
        // Calculate and set reportQtyAcres based on associated clus
//        calculateReportQtyAcres(fieldName);
        FieldName existingFieldName = getFieldNameById(id);
        // Update other properties as needed
        return fieldNameRepository.save(existingFieldName);
    }

    // Calculate and update reportQtyAcres based on associated clus
//    private void calculateReportQtyAcres(FieldName fieldName) {
//        double totalAcres = fieldName.getFieldNameCluMappings().stream()
//                .mapToDouble(clu -> clu.getAcres())
//                .sum();
//        fieldName.setReportQtyAcres(totalAcres);
//    }

    @Override
    public void deleteFieldName(Long id) {
        // Add validation and business logic if needed
        fieldNameRepository.deleteById(id);
    }
}
