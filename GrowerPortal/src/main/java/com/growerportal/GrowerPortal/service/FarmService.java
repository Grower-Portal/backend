package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.Farm;

import java.util.List;

public interface FarmService {
    List<Farm> getAllFarms();
    Farm getFarmById(Long id);
    Farm createFarm(Farm farm);
    Farm updateFarm(Long id, Farm farm);
    void deleteFarm(Long id);
}




