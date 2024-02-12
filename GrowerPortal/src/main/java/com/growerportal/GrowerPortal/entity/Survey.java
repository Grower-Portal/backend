package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "producer_info_id", referencedColumnName = "producerInfoId")
    private ProducerInfo producerInfo;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ccc860Attachment_id", referencedColumnName = "id")
    private Attachment ccc860Attachment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masterFarmerParticipationAttachment_id", referencedColumnName = "id")
    private Attachment masterFarmerParticipationAttachment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "srNDAAttachment_id", referencedColumnName = "id")
    private Attachment srNDAAttachment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "srAgreementAttachment_id", referencedColumnName = "id")
    private Attachment srAgreementAttachment;

}