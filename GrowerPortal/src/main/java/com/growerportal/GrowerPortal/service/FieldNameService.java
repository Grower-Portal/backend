package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.FieldName;
import java.util.List;

public interface FieldNameService {
    List<FieldName> getAllFieldNames();
    FieldName getFieldNameById(Long id);
    FieldName createFieldName(FieldName fieldName);
    FieldName updateFieldName(Long id, FieldName fieldName);
    void deleteFieldName(Long id);
}

