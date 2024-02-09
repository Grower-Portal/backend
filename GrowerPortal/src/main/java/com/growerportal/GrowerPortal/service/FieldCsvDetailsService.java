package com.growerportal.GrowerPortal.service;


import org.springframework.stereotype.Service;

@Service
public interface FieldCsvDetailsService {
    String findFsaPhysicalLocationByFarmTractClu(
            Long farmNumber, Long tractNumber, Long cluNumber);

    Double findCluCalculatedAcreageByFarmTractClu(
            Long farmNumber, Long tractNumber, Long cluNumber);
}
