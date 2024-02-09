package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.ProducerInfo;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.repository.ProducerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProducerInfoService {

    @Autowired
    private ProducerInfoRepository producerInfoRepository;

    @Autowired
    private FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    public List<AddApplicationDto.ProducerInfoDto> getAllProducerInfo() {
        List<ProducerInfo> producerInfoList = producerInfoRepository.findAll();
        List<AddApplicationDto.ProducerInfoDto> producerInfoDtoList = new ArrayList<>();

        for (ProducerInfo producerInfo : producerInfoList) {
            AddApplicationDto.ProducerInfoDto producerInfoDto = producerInfo.toDTO();
            producerInfoDtoList.add(producerInfoDto);
        }

        return producerInfoDtoList;
    }

    public Optional<AddApplicationDto.ProducerInfoDto> getProducerInfoById(Long id) {
        Optional<ProducerInfo> producerInfo = producerInfoRepository.findById(id);
        return producerInfo.map(ProducerInfo::toDTO);
    }

    public AddApplicationDto.ProducerInfoDto createProducerInfo(AddApplicationDto.ProducerInfoDto producerInfoDto) {
        if (producerInfoDto != null) {
            ProducerInfo producerInfo = new ProducerInfo();
            mapDTOToEntity(producerInfoDto, producerInfo);


                // Now you can save the application entity
                producerInfo = producerInfoRepository.save(producerInfo);
                return producerInfo.toDTO();

//            producerInfo = producerInfoRepository.save(producerInfo);
//            return producerInfo.toDTO();
        }
        // Handle the case where producerInfoDto is null (e.g., throw an exception or return an appropriate response)
        return null;
    }

    public void updateProducerInfo(Long id, AddApplicationDto.ProducerInfoDto producerInfoDto) {
        Optional<ProducerInfo> existingProducerInfo = producerInfoRepository.findById(id);
        existingProducerInfo.ifPresent(producerInfo -> {
            mapDTOToEntity(producerInfoDto, producerInfo);
            producerInfoRepository.save(producerInfo);
        });
    }

    public void deleteProducerInfo(Long id) {
        producerInfoRepository.deleteById(id);
    }

    private void mapDTOToEntity(AddApplicationDto.ProducerInfoDto dto, ProducerInfo entity) {
        entity.setProducerName(dto.getProducerName());
        entity.setProducerEntityName(dto.getProducerEntityName());
        entity.setCountyOfResidence(dto.getCountyOfResidence());
        entity.setProducerAddress(dto.getProducerAddress());
        entity.setIsUnderservedSmallProducer(dto.getIsUnderservedSmallProducer());
        entity.setBaselineYield(dto.getBaselineYield());
        entity.setPrimaryReasonForApplying(dto.getPrimaryReasonForApplying());
        entity.setImplementedCsafPractices(dto.getImplementedCsafPractices());
    }
}
