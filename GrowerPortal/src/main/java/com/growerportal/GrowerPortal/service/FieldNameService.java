package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;

import java.util.List;

public interface FieldNameService {
    List<AddApplicationDto.FieldNameDto> getAllFieldNames();
    AddApplicationDto.FieldNameDto getFieldNameById(Long id);
    AddApplicationDto.FieldNameDto createFieldName(AddApplicationDto.FieldNameDto fieldNameDto);
    AddApplicationDto.FieldNameDto updateFieldName(Long id, AddApplicationDto.FieldNameDto fieldNameDto);
    void deleteFieldName(Long id);
}

