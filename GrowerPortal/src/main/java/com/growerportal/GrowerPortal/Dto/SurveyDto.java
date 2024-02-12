package com.growerportal.GrowerPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDto {
    private Long producerInfoId;
    private Integer controllingMembersCount;
    private Boolean hasCCC860Certification;
    private Integer membersContributingToCCC860;
    private Boolean hasParticipatedInLSUMasterFarmerProgram;
    private Integer membersParticipatedInLSUMasterFarmerProgram;
    private String highestDegreeOfParticipationInMasterFarmerProgram;
    private Integer yearsOfExperience;
    private Boolean farmedRiceIn2023;
    private Integer riceAcresFarmedIn2023;
    private Boolean isFirstYearFarmingRice;
    private Integer mostRecentYearFarmingRice;
    private Integer riceAcresFarmedInMostRecentYear;
    private Integer percentageOfIncomeFromOnFarmActivities;
    private Boolean volunteersForEconomicAnalysis;
    private Boolean understandsContractWithSupremeRice;
    private Boolean understandsProhibitionOfDouble;
    private Boolean understandsPaymentFromSupreme;
    private Boolean hasAuthorityToCompleteApplication;
    // Single file attachments
    private MultipartFile ccc860Attachment;
    private MultipartFile masterFarmerParticipationAttachment;
    private MultipartFile srNDAAttachment;
    private MultipartFile srAgreementAttachment;



    // Add any additional fields or methods as needed
}