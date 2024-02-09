package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.repository.FieldCsvDetailsRepository;
import com.growerportal.GrowerPortal.service.FieldCsvDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FieldCsvDetailsServiceImpl implements FieldCsvDetailsService {

    private final FieldCsvDetailsRepository fieldCsvDetailsRepository;

    @Autowired
    public FieldCsvDetailsServiceImpl(FieldCsvDetailsRepository fieldCsvDetailsRepository) {
        this.fieldCsvDetailsRepository = fieldCsvDetailsRepository;
    }

    @Override
    public String findFsaPhysicalLocationByFarmTractClu(
            Long farmNumber, Long tractNumber, Long cluNumber) {
        return fieldCsvDetailsRepository.findFsaPhysicalLocationByFarmTractClu(farmNumber, tractNumber, cluNumber);
    }

    @Override
    public Double findCluCalculatedAcreageByFarmTractClu(
            Long farmNumber, Long tractNumber, Long cluNumber) {
        return fieldCsvDetailsRepository.findCluCalculatedAcreageByFarmTractClu(farmNumber, tractNumber, cluNumber);
    }
}
