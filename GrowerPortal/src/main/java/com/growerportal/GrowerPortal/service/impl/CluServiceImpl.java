package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.entity.Clu;
import com.growerportal.GrowerPortal.repository.CluRepository;
import com.growerportal.GrowerPortal.service.CluService;
import com.growerportal.GrowerPortal.util.CluNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CluServiceImpl implements CluService {

    private final CluRepository cluRepository;

    @Autowired
    public CluServiceImpl(CluRepository cluRepository) {
        this.cluRepository = cluRepository;
    }

    @Override
    public List<Clu> getAllClus() {
        return cluRepository.findAll();
    }

    @Override
    public Clu getCluById(Long id) {
        return cluRepository.findById(id)
                .orElseThrow(() -> new CluNotFoundException(id));
    }

    @Override
    public Clu createClu(Clu clu) {
        // Add validation and business logic if needed
        return cluRepository.save(clu);
    }

    @Override
    public Clu updateClu(Long id, Clu clu) {
        // Add validation and business logic if needed
        Clu existingClu = getCluById(id);
        // Update properties as needed
        return cluRepository.save(existingClu);
    }

    @Override
    public void deleteClu(Long id) {
        // Add validation and business logic if needed
        cluRepository.deleteById(id);
    }
}
