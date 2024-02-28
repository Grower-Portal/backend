package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;


import java.util.List;

public interface TractService {
    List<AddApplicationDto.TractDto> getAllTracts();
    AddApplicationDto.TractDto getTractById(Long id);
    AddApplicationDto.TractDto createTract(AddApplicationDto.TractDto tractDto);
    AddApplicationDto.TractDto updateTract(Long id, AddApplicationDto.TractDto tractDto);
    void deleteTract(Long id);
}


