package com.growerportal.GrowerPortal.service.impl;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.entity.*;
import com.growerportal.GrowerPortal.repository.*;
import com.growerportal.GrowerPortal.service.CluService;
import com.growerportal.GrowerPortal.util.CluNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CluServiceImpl implements CluService {

    private final CluRepository cluRepository;

    @Autowired
    private FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    @Autowired
    private AddApplicationRepository applicationRepository;

    @Autowired
    private TractRepository tractRepository;

    @Autowired
    public CluServiceImpl(CluRepository cluRepository) {
        this.cluRepository = cluRepository;
    }

    @Override
    public List<AddApplicationDto.CluDto> getAllClus() {
        List<Clu> clus = cluRepository.findAll();
        List<AddApplicationDto.CluDto> cluDtos = new ArrayList<>();

        for (Clu clu : clus) {
            AddApplicationDto.CluDto dto = clu.toDto();
            cluDtos.add(dto);
        }

        return cluDtos;
    }

    @Override
    public AddApplicationDto.CluDto getCluById(Long id) {
        return cluRepository.findById(id)
                .map(Clu::toDto)
                .orElseThrow(() -> new CluNotFoundException(id));
    }

    @Override
    public AddApplicationDto.CluDto createClu(AddApplicationDto.CluDto cluDto) {
        Clu clu = new Clu();
        mapDtoToEntity(cluDto, clu);
        Optional<AddApplication> addApplicationOptional;


        Optional<Tract> tractOptional = tractRepository.findById(cluDto.getTractId());

            Tract tract = tractOptional.get();
            clu.setTract(tract);

            // Now you can save the application entity
            clu = cluRepository.save(clu);
            return clu.toDto();

//        Clu createdClu = cluRepository.save(clu);
//        return createdClu.toDto();
    }

    @Override
    public AddApplicationDto.CluDto updateClu(Long id, AddApplicationDto.CluDto cluDto) {
        Clu existingClu = cluRepository.findById(id)
                .orElseThrow(() -> new CluNotFoundException(id));

        mapDtoToEntity(cluDto, existingClu);
        Clu updatedClu = cluRepository.save(existingClu);
        return updatedClu.toDto();
    }

    @Override
    public void deleteClu(Long id) {
        cluRepository.deleteById(id);
    }

    private void mapDtoToEntity(AddApplicationDto.CluDto dto, Clu entity) {
        entity.setCluNumber(dto.getCluNumber());
        entity.setAcres(dto.getAcres());
        entity.setFsaPhysicalLocation(dto.getFsaPhysicalLocation());
        // Map other properties as needed
    }
}
