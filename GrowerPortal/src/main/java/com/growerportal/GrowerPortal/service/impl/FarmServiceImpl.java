package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.entity.Farm;
import com.growerportal.GrowerPortal.repository.FarmRepository;
import com.growerportal.GrowerPortal.service.FarmService;
import com.growerportal.GrowerPortal.util.FarmNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new FarmNotFoundException(id));
    }

    @Override
    public Farm createFarm(Farm farm) {
        // Add validation and business logic if needed
        return farmRepository.save(farm);
    }

    @Override
    public Farm updateFarm(Long id, Farm farm) {
        // Add validation and business logic if needed
        Farm existingFarm = getFarmById(id);
        existingFarm.setFarmNumber(farm.getFarmNumber());
        // Update other properties as needed
        return farmRepository.save(existingFarm);
    }

    @Override
    public void deleteFarm(Long id) {
        // Add validation and business logic if needed
        farmRepository.deleteById(id);
    }
}
