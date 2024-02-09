package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;

import java.util.List;

public interface FarmService {
    List<AddApplicationDto.FarmDto> getAllFarms();
    AddApplicationDto.FarmDto getFarmById(Long id);
    AddApplicationDto.FarmDto createFarm(AddApplicationDto.FarmDto farmDto);
    AddApplicationDto.FarmDto updateFarm(Long id, AddApplicationDto.FarmDto farmDto);
    void deleteFarm(Long id);
}




