package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.entity.FieldName;
import com.growerportal.GrowerPortal.repository.FieldNameRepository;
import com.growerportal.GrowerPortal.service.FieldNameService;
import com.growerportal.GrowerPortal.util.FieldNameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieldNameServiceImpl implements FieldNameService {

    private final FieldNameRepository fieldNameRepository;

    @Autowired
    public FieldNameServiceImpl(FieldNameRepository fieldNameRepository) {
        this.fieldNameRepository = fieldNameRepository;
    }

    @Override
    public List<AddApplicationDto.FieldNameDto> getAllFieldNames() {
        List<FieldName> fieldNames = fieldNameRepository.findAll();
        List<AddApplicationDto.FieldNameDto> fieldNameDtos = new ArrayList<>();

        for (FieldName fieldName : fieldNames) {
            AddApplicationDto.FieldNameDto dto = fieldName.toDto();
            fieldNameDtos.add(dto);
        }

        return fieldNameDtos;
    }

    @Override
    public AddApplicationDto.FieldNameDto getFieldNameById(Long id) {
        return fieldNameRepository.findById(id)
                .map(FieldName::toDto)
                .orElseThrow(() -> new FieldNameNotFoundException(id));
    }

    @Override
    public AddApplicationDto.FieldNameDto createFieldName(AddApplicationDto.FieldNameDto fieldNameDto) {
        FieldName fieldName = new FieldName();
        mapDtoToEntity(fieldNameDto, fieldName);
        FieldName createdFieldName = fieldNameRepository.save(fieldName);
        return createdFieldName.toDto();
    }

    @Override
    public AddApplicationDto.FieldNameDto updateFieldName(Long id, AddApplicationDto.FieldNameDto fieldNameDto) {
        FieldName existingFieldName = fieldNameRepository.findById(id)
                .orElseThrow(() -> new FieldNameNotFoundException(id));

        mapDtoToEntity(fieldNameDto, existingFieldName);
        FieldName updatedFieldName = fieldNameRepository.save(existingFieldName);
        return updatedFieldName.toDto();
    }

    @Override
    public void deleteFieldName(Long id) {
        fieldNameRepository.deleteById(id);
    }

    private void mapDtoToEntity(AddApplicationDto.FieldNameDto dto, FieldName entity) {
        entity.setFieldName(dto.getFieldName());
        // Map other properties as needed
    }
}

