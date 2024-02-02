package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.entity.Tract;
import com.growerportal.GrowerPortal.repository.TractRepository;
import com.growerportal.GrowerPortal.service.TractService;
import com.growerportal.GrowerPortal.util.TractNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TractServiceImpl implements TractService {

    private final TractRepository tractRepository;

    @Autowired
    public TractServiceImpl(TractRepository tractRepository) {
        this.tractRepository = tractRepository;
    }

    @Override
    public List<Tract> getAllTracts() {
        return tractRepository.findAll();
    }

    @Override
    public Tract getTractById(Long id) {
        return tractRepository.findById(id)
                .orElseThrow(() -> new TractNotFoundException(id));
    }

    @Override
    public Tract createTract(Tract tract) {
        // Add validation and business logic if needed
        return tractRepository.save(tract);
    }

    @Override
    public Tract updateTract(Long id, Tract tract) {
        // Add validation and business logic if needed
        Tract existingTract = getTractById(id);
        existingTract.setTractNumber(tract.getTractNumber());
        // Update other properties as needed
        return tractRepository.save(existingTract);
    }

    @Override
    public void deleteTract(Long id) {
        // Add validation and business logic if needed
        tractRepository.deleteById(id);
    }
}
