package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmDetailsService {
        private final List<AddApplicationDto.FarmDetailsDto> farmDetailsList = new ArrayList<>();
        private Long farmDetailIdCounter = 1L;

        public List<AddApplicationDto.FarmDetailsDto> getAllFarmDetails() {
            return farmDetailsList;
        }

        public AddApplicationDto.FarmDetailsDto getFarmDetailsDtoById(Long id) {
            for (AddApplicationDto.FarmDetailsDto farmDetails : farmDetailsList) {
                if (farmDetails.getFarmDetailId().equals(id)) {
                    return farmDetails;
                }
            }
            return null;
        }

        public AddApplicationDto.FarmDetailsDto createFarmDetailsDto(AddApplicationDto.FarmDetailsDto farmDetailsDto) {
            farmDetailsDto.setFarmDetailId(farmDetailIdCounter++);
            farmDetailsList.add(farmDetailsDto);
            return farmDetailsDto;
        }

        public AddApplicationDto.FarmDetailsDto updateFarmDetailsDto(Long id, AddApplicationDto.FarmDetailsDto farmDetailsDto) {
            AddApplicationDto.FarmDetailsDto existingFarmDetailsDto = getFarmDetailsDtoById(id);
            if (existingFarmDetailsDto != null) {
                BeanUtils.copyProperties(farmDetailsDto, existingFarmDetailsDto, "farmDetailId");
                return existingFarmDetailsDto;
            }
            return null;
        }

        public void deleteFarmDetails(Long id) {
            AddApplicationDto.FarmDetailsDto farmDetailsDto = getFarmDetailsDtoById(id);
            if (farmDetailsDto != null) {
                farmDetailsList.remove(farmDetailsDto);
            }
        }
}

