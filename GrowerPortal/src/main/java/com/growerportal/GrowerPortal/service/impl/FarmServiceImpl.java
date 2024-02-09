package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.entity.AddApplication;
import com.growerportal.GrowerPortal.entity.Farm;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.repository.AddApplicationRepository;
import com.growerportal.GrowerPortal.repository.FarmRepository;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.service.FarmService;
import com.growerportal.GrowerPortal.util.FarmNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    @Autowired
    private FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    @Autowired
    private AddApplicationRepository applicationRepository;

    @Autowired
    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public List<AddApplicationDto.FarmDto> getAllFarms() {
        List<Farm> farms = farmRepository.findAll();
        List<AddApplicationDto.FarmDto> farmDtos = new ArrayList<>();

        for (Farm farm : farms) {
            AddApplicationDto.FarmDto dto = farm.toDto();
            farmDtos.add(dto);
        }

        return farmDtos;
    }

    @Override
    public AddApplicationDto.FarmDto getFarmById(Long id) {
        return farmRepository.findById(id)
                .map(Farm::toDto)
                .orElseThrow(() -> new FarmNotFoundException(id));
    }

    @Override
    public AddApplicationDto.FarmDto createFarm(AddApplicationDto.FarmDto farmDto) {
        if (farmDto != null) {
            Farm farm = new Farm();
            mapDtoToEntity(farmDto, farm);


                // Now you can save the application entity
                farm = farmRepository.save(farm);
                return farm.toDto();
//            Farm createdFarm = farmRepository.save(farm);
//            return createdFarm.toDto();
        }
        return null;
    }

    @Override
    public AddApplicationDto.FarmDto updateFarm(Long id, AddApplicationDto.FarmDto farmDto) {
        Farm existingFarm = farmRepository.findById(id)
                .orElseThrow(() -> new FarmNotFoundException(id));

        mapDtoToEntity(farmDto, existingFarm);
        Farm updatedFarm = farmRepository.save(existingFarm);
        return updatedFarm.toDto();
    }

    @Override
    public void deleteFarm(Long id) {
        farmRepository.deleteById(id);
    }

    private void mapDtoToEntity(AddApplicationDto.FarmDto dto, Farm entity) {
        entity.setFarmNumber(dto.getFarmNumber());
        // Map other properties as needed
    }
}
