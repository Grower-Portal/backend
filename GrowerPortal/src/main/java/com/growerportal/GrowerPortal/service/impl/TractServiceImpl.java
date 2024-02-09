package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.entity.AddApplication;
import com.growerportal.GrowerPortal.entity.Farm;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.Tract;
import com.growerportal.GrowerPortal.repository.AddApplicationRepository;
import com.growerportal.GrowerPortal.repository.FarmRepository;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import com.growerportal.GrowerPortal.repository.TractRepository;
import com.growerportal.GrowerPortal.service.TractService;
import com.growerportal.GrowerPortal.util.TractNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TractServiceImpl implements TractService {

    private final TractRepository tractRepository;

    @Autowired
    private FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    @Autowired
    private AddApplicationRepository applicationRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    public TractServiceImpl(TractRepository tractRepository) {
        this.tractRepository = tractRepository;
    }

    @Override
    public List<AddApplicationDto.TractDto> getAllTracts() {
        List<Tract> tracts = tractRepository.findAll();
        List<AddApplicationDto.TractDto> tractDtos = new ArrayList<>();

        for (Tract tract : tracts) {
            AddApplicationDto.TractDto dto = tract.toDto();
            tractDtos.add(dto);
        }

        return tractDtos;
    }

    @Override
    public AddApplicationDto.TractDto getTractById(Long id) {
        return tractRepository.findById(id)
                .map(Tract::toDto)
                .orElseThrow(() -> new TractNotFoundException(id));
    }

    @Override
    public AddApplicationDto.TractDto createTract(AddApplicationDto.TractDto tractDto) {
        Tract tract = new Tract();
        mapDtoToEntity(tractDto, tract);



        Optional<Farm> farmOptional = farmRepository.findById(tractDto.getFarmId());


            Farm farm = farmOptional.get();
            tract.setFarm(farm);

            // Now you can save the application entity
            tract = tractRepository.save(tract);
            return tract.toDto();
//        Tract createdTract = tractRepository.save(tract);
//        return createdTract.toDto();
    }

    @Override
    public AddApplicationDto.TractDto updateTract(Long id, AddApplicationDto.TractDto tractDto) {
        Tract existingTract = tractRepository.findById(id)
                .orElseThrow(() -> new TractNotFoundException(id));

        mapDtoToEntity(tractDto, existingTract);
        Tract updatedTract = tractRepository.save(existingTract);
        return updatedTract.toDto();
    }

    @Override
    public void deleteTract(Long id) {
        tractRepository.deleteById(id);
    }

    private void mapDtoToEntity(AddApplicationDto.TractDto dto, Tract entity) {
        entity.setTractNumber(dto.getTractNumber());
        // Map other properties as needed
    }
}
