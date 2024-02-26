package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.entity.*;
import com.growerportal.GrowerPortal.repository.AddApplicationRepository;
import com.growerportal.GrowerPortal.repository.FarmerPersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddApplicationService {

    @Autowired
    private AddApplicationRepository addApplicationRepository;

    @Autowired
    private FarmerPersonalInfoRepository farmerPersonalInfoRepository;

    public List<AddApplicationDto> getAllApplications() {
        List<AddApplication> applications = addApplicationRepository.findAll();
        return applications.stream()
                .map(AddApplication::toDto)
                .collect(Collectors.toList());
    }

    // public Optional<AddApplicationDto> getApplicationById(Long id) {
    //     Optional<AddApplication> application = addApplicationRepository.findById(id);
    //     return application.map(AddApplication::toDto);
    // }

        public  Optional<AddApplicationDto> getApplicationById(Long id) {
        Optional<AddApplication> applicationOptional = addApplicationRepository.findById(id);
            // Handle case where application with specified ID is not found
            return applicationOptional.map(addApplication -> Optional.ofNullable(addApplication.toDto())).orElse(null);
        }

    public AddApplicationDto createApplication(AddApplicationDto applicationDto) {
        if (applicationDto != null) {
            AddApplication application = mapDtoToEntity(applicationDto);

            // Retrieve the farmer based on farmerId from the database
            Optional<FarmerPersonalInfo> farmerOptional = farmerPersonalInfoRepository.findById(applicationDto.getFarmerId());

            if (farmerOptional.isPresent()) {
                FarmerPersonalInfo farmer = farmerOptional.get();
                application.setFarmer(farmer);

                // Save the application entity
                application = addApplicationRepository.save(application);
                return application.toDto();
            } else {
                // Handle the case where the farmer with the specified ID does not exist
                return null;
            }
        }
        return null;
    }

    public void updateApplication(Long id, AddApplicationDto updatedApplicationDto) {
        Optional<AddApplication> existingApplication = addApplicationRepository.findById(id);
        existingApplication.ifPresent(application -> {
            mapDtoToEntity(updatedApplicationDto);
            addApplicationRepository.save(application);
        });
    }

    public void deleteApplication(Long id) {
        addApplicationRepository.deleteById(id);
    }

    private AddApplication mapDtoToEntity(AddApplicationDto dto) {
        AddApplication entity = new AddApplication();
        //entity.setApplicationId(dto.getApplicationId());
        entity.setApplicationDate(dto.getApplicationDate());
        entity.setStatus(dto.getStatus());

        // Map ProducerInfoDto
        if (Objects.nonNull(dto.getProducerInfo())) {
            ProducerInfo producerInfo = new ProducerInfo();
            //producerInfo.setProducerInfoId(dto.getProducerInfo().getProducerInfoId());
            // Map other fields as needed
            producerInfo.setProducerName(dto.getProducerInfo().getProducerName());
            producerInfo.setProducerEntityName(dto.getProducerInfo().getProducerEntityName());
            producerInfo.setCountyOfResidence(dto.getProducerInfo().getCountyOfResidence());
            producerInfo.setProducerAddress(dto.getProducerInfo().getProducerAddress());
            producerInfo.setIsUnderservedSmallProducer(dto.getProducerInfo().getIsUnderservedSmallProducer());
            producerInfo.setBaselineYield(dto.getProducerInfo().getBaselineYield());
            producerInfo.setPrimaryReasonForApplying(dto.getProducerInfo().getPrimaryReasonForApplying());
            producerInfo.setImplementedCsafPractices(dto.getProducerInfo().getImplementedCsafPractices());
            producerInfo.setAddApplication(entity);
            // Map FieldNameDto
            if (Objects.nonNull(dto.getProducerInfo().getFarm())) {
                for (AddApplicationDto.FarmDto farmDto : dto.getProducerInfo().getFarm()) {
                    Farm farm = new Farm();
                   // farm.setFarmId(farmDto.getFarmId());
                    farm.setFarmNumber(farmDto.getFarmNumber());
                    farm.setFieldName(farm.getFieldName());
                    farm.setTracts(farm.getTracts());
                    farm.setProducerInfo(producerInfo);
                    farm.setFarmDetails(farm.getFarmDetails());
                    // Map other fields as needed
                    // Map CommodityInfoDto if exists
                    if (Objects.nonNull(farmDto.getFieldName())) {
                        for (AddApplicationDto.FieldNameDto fieldNameDto : farmDto.getFieldName()) {
                            FieldName fieldName = new FieldName();
                         //   fieldName.setFieldNameId(fieldNameDto.getFieldNameId());
                            fieldName.setFieldName(fieldNameDto.getFieldName());
                            fieldName.setReportQtyAcres(fieldNameDto.getReportQtyAcres());
                            fieldName.setCommodityInfo(fieldName.getCommodityInfo());
                            fieldName.setFarm(farm);

                            if (Objects.nonNull(fieldNameDto.getCommodityInfo())) {
                                CommodityInfo commodityInfo = new CommodityInfo();
                                commodityInfo.setReportQtyAcres(fieldNameDto.getCommodityInfo().getReportQtyAcres());
                                commodityInfo.setCommodityCategory(fieldNameDto.getCommodityInfo().getCommodityCategory());
                                commodityInfo.setCommodityType(fieldNameDto.getCommodityInfo().getCommodityType());
                                commodityInfo.setLandUseHistory(fieldNameDto.getCommodityInfo().getLandUseHistory());
                                commodityInfo.setIrrigationHistory(fieldNameDto.getCommodityInfo().getIrrigationHistory());
                                commodityInfo.setTillageHistory(fieldNameDto.getCommodityInfo().getTillageHistory());
                                commodityInfo.setCsafPracticeHistory(fieldNameDto.getCommodityInfo().getCsafPracticeHistory());
                                commodityInfo.setPastCsafPracticeHistory(fieldNameDto.getCommodityInfo().getPastCsafPracticeHistory());
                                commodityInfo.setFieldName(fieldName);
                                fieldName.setCommodityInfo(commodityInfo);
                            }
                            farm.addFieldName(fieldName);
                        }
                    }


                    if (Objects.nonNull(farmDto.getFarmDetails())) {
                        FarmDetails farmDetails = new FarmDetails();
              //          farmDetails.setFarmDetailId(farmDto.getFarmDetails().getFarmDetailId());
                        farmDetails.setApplicationAcres(farmDto.getFarmDetails().getApplicationAcres());
                        farmDetails.setProduceLivestock(farmDto.getFarmDetails().getProduceLivestock());
                        farmDetails.setLivestockType1(farmDto.getFarmDetails().getLivestockType1());
                        farmDetails.setLivestockHead1(farmDto.getFarmDetails().getLivestockHead1());
                        farmDetails.setLivestockType2(farmDto.getFarmDetails().getLivestockType2());
                        farmDetails.setLivestockHead2(farmDto.getFarmDetails().getLivestockHead2());
                        farmDetails.setLivestockType3(farmDto.getFarmDetails().getLivestockType3());
                        farmDetails.setFsaPhysicalLocation(farmDto.getFarmDetails().getFsaPhysicalLocation());
                        farmDetails.setTotalLiveStockAcres(farmDto.getFarmDetails().getTotalLiveStockAcres());
                        farmDetails.setPastCsafPractice(farmDto.getFarmDetails().getPastCsafPractice());
                        farmDetails.setTotalCroplandAcres(farmDto.getFarmDetails().getTotalCroplandAcres());
                        farmDetails.setTotalLandAreaAcres(farmDto.getFarmDetails().getTotalLandAreaAcres());
                        farmDetails.setTotalForestAreaAcres(farmDto.getFarmDetails().getTotalForestAreaAcres());
                        farmDetails.setTransitioningToUsdaCertified(farmDto.getFarmDetails().getTransitioningToUsdaCertified());
                        farmDetails.setFarm(farm);
                        farm.setFarmDetails(farmDetails); // Set farmDetails to farm

                    }

                    // Map TractDto
                    if (Objects.nonNull(farmDto.getTract())) {
                        for (AddApplicationDto.TractDto tractDto : farmDto.getTract()) {
                            Tract tract = new Tract();
                       //     tract.setTractId(tractDto.getTractId());
                            tract.setTractNumber(tractDto.getTractNumber());
                            tract.setClus(tract.getClus());
                            tract.setFarm(farm);
                            // Map other fields as needed

                            // Map CluDto
                            if (Objects.nonNull(tractDto.getClu())) {
                                for (AddApplicationDto.CluDto cluDto : tractDto.getClu()) {
                                    Clu clu = new Clu();
                         //           clu.setCluId(cluDto.getCluId());
                                    clu.setCluNumber(cluDto.getCluNumber());
                                    clu.setAcres(cluDto.getAcres());
                                    clu.setFsaPhysicalLocation(cluDto.getFsaPhysicalLocation());
                                    clu.setTract(tract);
                                    // Map other fields as needed

                                    tract.addClu(clu);
                                }
                            }
                            farm.addTract(tract);
                        }
                    }

                    producerInfo.addFarm(farm);
                }
            }
            entity.setProducerInfo(producerInfo);
        }
        return entity;
    }

    public List<AddApplicationDto> getApplicationsByFarmerId(FarmerPersonalInfo farmer) {
        // Retrieve all applications related to the farmer from the applications table
        List<AddApplication> farmerApplications = addApplicationRepository.findByFarmerId(4L);

        // Map farmer applications to ApplicationDto
        List<AddApplicationDto> applicationDtos = farmerApplications.stream()
                .map(AddApplication::toDto)
                .collect(Collectors.toList());

        return applicationDtos;
    }
}

