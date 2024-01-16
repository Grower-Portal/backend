package com.growerportal.GrowerPortal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDto {
    private Long id;
    private Long farmId;
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
    private Boolean understandsProhibitionOfDoubleFunding;
    private Boolean understandsPaymentFromSupreme;
    private Boolean hasAuthorityToCompleteApplication;
    private Long ccc860AttachmentId;
    private Long masterFarmerParticipationAttachmentId;
    private Long srNDAAttachmentId;
    private Long srAgreementAttachmentId;

}
