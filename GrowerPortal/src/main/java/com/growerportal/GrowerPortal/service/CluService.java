package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;

import java.util.List;

public interface CluService {
    List<AddApplicationDto.CluDto> getAllClus();
    AddApplicationDto.CluDto getCluById(Long id);
    AddApplicationDto.CluDto createClu(AddApplicationDto.CluDto cluDto);
    AddApplicationDto.CluDto updateClu(Long id, AddApplicationDto.CluDto cluDto);
    void deleteClu(Long id);
}


