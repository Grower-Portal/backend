package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.FarmDetails;
import com.growerportal.GrowerPortal.repository.FarmDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmDetailsService {

    private final FarmDetailsRepository farmDetailsRepository;

    @Autowired
    public FarmDetailsService(FarmDetailsRepository farmDetailsRepository) {
        this.farmDetailsRepository = farmDetailsRepository;
    }

    public List<FarmDetails> getAllFarmDetails() {
        return farmDetailsRepository.findAll();
    }

    public FarmDetails getFarmDetailsById(Long id) {
        return farmDetailsRepository.findById(id).orElse(null);
    }

    public FarmDetails createFarmDetails(FarmDetails farmDetails) {
        return farmDetailsRepository.save(farmDetails);
    }

    public FarmDetails updateFarmDetails(Long id, FarmDetails farmDetails) {
        FarmDetails existingFarmDetails = getFarmDetailsById(id);
        if (existingFarmDetails == null) {
            return null; // Handle not found case
        }

        // Update properties of existingFarmDetails with values from farmDetails

        return farmDetailsRepository.save(existingFarmDetails);
    }

    public void deleteFarmDetails(Long id) {
        farmDetailsRepository.deleteById(id);
    }
}

