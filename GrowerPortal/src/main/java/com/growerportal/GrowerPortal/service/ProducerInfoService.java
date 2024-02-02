package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.ProducerInfo;
import com.growerportal.GrowerPortal.repository.ProducerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerInfoService {

    @Autowired
    private ProducerInfoRepository producerInfoRepository;

    public List<ProducerInfo> getAllProducerInfo() {
        return producerInfoRepository.findAll();
    }

    public Optional<ProducerInfo> getProducerInfoById(Long id) {
        return producerInfoRepository.findById(id);
    }

    public ProducerInfo createProducerInfo(ProducerInfo producerInfo) {
        return producerInfoRepository.save(producerInfo);
    }

    public void updateProducerInfo(Long id, ProducerInfo newProducerInfo) {
        Optional<ProducerInfo> existingProducerInfo = producerInfoRepository.findById(id);
        if (existingProducerInfo.isPresent()) {
            // Update the existing entity's properties
            ProducerInfo updatedProducerInfo = existingProducerInfo.get();
            updatedProducerInfo.setProducerName(newProducerInfo.getProducerName());
            updatedProducerInfo.setProducerEntityName(newProducerInfo.getProducerEntityName());
            updatedProducerInfo.setCountyOfResidence(newProducerInfo.getCountyOfResidence());
            updatedProducerInfo.setProducerAddress(newProducerInfo.getProducerAddress());
            updatedProducerInfo.setIsUnderservedSmallProducer(newProducerInfo.getIsUnderservedSmallProducer());
            updatedProducerInfo.setBaselineYield(newProducerInfo.getBaselineYield());
            updatedProducerInfo.setPrimaryReasonForApplying(newProducerInfo.getPrimaryReasonForApplying());
            updatedProducerInfo.setImplementedCsafPractices(newProducerInfo.getImplementedCsafPractices());

            // Save the updated entity
            producerInfoRepository.save(updatedProducerInfo);
        }
    }

    public void deleteProducerInfo(Long id) {
        producerInfoRepository.deleteById(id);
    }
}
