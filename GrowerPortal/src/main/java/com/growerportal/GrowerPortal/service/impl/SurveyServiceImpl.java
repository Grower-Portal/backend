package com.growerportal.GrowerPortal.service.impl;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.growerportal.GrowerPortal.dto.SurveyDto;
import com.growerportal.GrowerPortal.entity.Attachment;
import com.growerportal.GrowerPortal.entity.ProducerInfo;
import com.growerportal.GrowerPortal.entity.Survey;
import com.growerportal.GrowerPortal.repository.AttachmentRepository;
import com.growerportal.GrowerPortal.repository.ProducerInfoRepository;
import com.growerportal.GrowerPortal.repository.SurveyRepository;
import com.growerportal.GrowerPortal.service.SurveyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;
    private final ProducerInfoRepository producerInfoRepository;

    private final AttachmentRepository attachmentRepository;
    
    @Autowired
    private Storage storage;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository, ProducerInfoRepository producerInfoRepository, AttachmentRepository attachmentRepository) {
        this.surveyRepository = surveyRepository;
        this.producerInfoRepository = producerInfoRepository;
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Survey saveSurvey(SurveyDto surveyDto) throws IOException {
        Survey survey = new Survey();

        survey.setControllingMembersCount(surveyDto.getControllingMembersCount());
        survey.setHasCCC860Certification(surveyDto.getHasCCC860Certification());
        survey.setMembersContributingToCCC860(surveyDto.getMembersContributingToCCC860());
        survey.setHasParticipatedInLSUMasterFarmerProgram(surveyDto.getHasParticipatedInLSUMasterFarmerProgram());
        survey.setMembersParticipatedInLSUMasterFarmerProgram(surveyDto.getMembersParticipatedInLSUMasterFarmerProgram());
        survey.setHighestDegreeOfParticipationInMasterFarmerProgram(surveyDto.getHighestDegreeOfParticipationInMasterFarmerProgram());
        survey.setYearsOfExperience(surveyDto.getYearsOfExperience());
        survey.setFarmedRiceIn2023(surveyDto.getFarmedRiceIn2023());
        survey.setRiceAcresFarmedIn2023(surveyDto.getRiceAcresFarmedIn2023());
        survey.setIsFirstYearFarmingRice(surveyDto.getIsFirstYearFarmingRice());
        survey.setMostRecentYearFarmingRice(surveyDto.getMostRecentYearFarmingRice());
        survey.setRiceAcresFarmedInMostRecentYear(surveyDto.getRiceAcresFarmedInMostRecentYear());
        survey.setPercentageOfIncomeFromOnFarmActivities(surveyDto.getPercentageOfIncomeFromOnFarmActivities());
        survey.setVolunteersForEconomicAnalysis(surveyDto.getVolunteersForEconomicAnalysis());
        survey.setUnderstandsContractWithSupremeRice(surveyDto.getUnderstandsContractWithSupremeRice());
        survey.setUnderstandsProhibitionOfDoubleFunding(surveyDto.getUnderstandsProhibitionOfDouble());
        survey.setUnderstandsPaymentFromSupreme(surveyDto.getUnderstandsPaymentFromSupreme());
        survey.setHasAuthorityToCompleteApplication(surveyDto.getHasAuthorityToCompleteApplication());
        survey.setCcc860Attachment(saveFileToGCS(surveyDto.getCcc860Attachment(), surveyDto.getProducerInfoId()));
        survey.setMasterFarmerParticipationAttachment(saveFileToGCS(surveyDto.getMasterFarmerParticipationAttachment(), surveyDto.getProducerInfoId()));
        survey.setSrNDAAttachment(saveFileToGCS(surveyDto.getSrNDAAttachment(), surveyDto.getProducerInfoId()));
        survey.setSrAgreementAttachment(saveFileToGCS(surveyDto.getSrAgreementAttachment(), surveyDto.getProducerInfoId()));
        mapProducerInfo(surveyDto, survey);
        return surveyRepository.save(survey);
    }


    
    private void mapProducerInfo(SurveyDto surveyDto, Survey survey) {
        if (surveyDto.getProducerInfoId() != null) {
            ProducerInfo producerInfo = producerInfoRepository.findById(surveyDto.getProducerInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("ProducerInfo not found with id: " + surveyDto.getProducerInfoId()));

            survey.setProducerInfo(producerInfo);
         producerInfo.setSurvey(survey);
            producerInfoRepository.save(producerInfo);
        }
    }

    public Attachment saveFileToGCS(MultipartFile file, Long producerId) throws IOException {
        if (file != null && !file.isEmpty()) {
            String directoryPath = "producer_" + producerId + "/"; // Create directory path with producer ID
            String uniqueFileName = generateUniqueFileName(file.getOriginalFilename()); // Generate a unique file name
            BlobId blobId = BlobId.of("grower-portal-bucket-1", directoryPath + uniqueFileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
            storage.create(blobInfo, file.getBytes());

            // Save the GCS file path in the Attachment entity
            Attachment attachment = new Attachment();
            attachment.setFileName(uniqueFileName);
            attachment.setFileType(file.getContentType());
            attachment.setGcsFilePath("gs://" + blobId.getBucket() + "/" + blobId.getName());

            return attachmentRepository.save(attachment);
        }
        return null;
    }
    private String generateUniqueFileName(String originalFileName) {
        String uniqueIdentifier = UUID.randomUUID().toString().substring(0, 8); // Generate a unique identifier
        String fileExtension = getFileExtension(originalFileName); // Get the file extension
        return originalFileName + "_" + uniqueIdentifier + "." + fileExtension;
    }

    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }
}