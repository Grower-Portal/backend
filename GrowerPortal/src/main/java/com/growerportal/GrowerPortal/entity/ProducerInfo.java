package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "producer_info")
public class ProducerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producerInfoId;

    @OneToOne
    @JoinColumn(name = "application_id")
    @JsonBackReference
    private AddApplication addApplication;

    @OneToMany(mappedBy = "producerInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<FieldName> fieldName = new HashSet<>();

    @Column(nullable = false)
    private String producerName;

    @Column(nullable = false)
    private String producerEntityName;

    @Column(nullable = false)
    private String countyOfResidence;

    @Column(nullable = false)
    private String producerAddress;

    @Column(nullable = false)
    private String isUnderservedSmallProducer;

    @Column(nullable = false)
    private int baselineYield;

    @Column(nullable = false)
    private String primaryReasonForApplying;

    @Column(nullable = false)
    private String implementedCsafPractices;

    @OneToOne(mappedBy = "producerInfo")
    private Survey survey;

    // Standard constructors, getters, and setters
    public void addFieldName(FieldName fieldName) {
        this.fieldName.add(fieldName);
        fieldName.setProducerInfo(this);
    }

    public AddApplicationDto.ProducerInfoDto toDTO() {
        AddApplicationDto.ProducerInfoDto dto = new AddApplicationDto.ProducerInfoDto();
        dto.setProducerInfoId(this.producerInfoId);
        dto.setApplicationId(this.addApplication != null ? this.addApplication.getApplicationId() : null);
        dto.setProducerName(this.producerName);
        dto.setProducerEntityName(this.producerEntityName);
        dto.setCountyOfResidence(this.countyOfResidence);
        dto.setProducerAddress(this.producerAddress);
        dto.setIsUnderservedSmallProducer(this.isUnderservedSmallProducer);
        dto.setBaselineYield(this.baselineYield);
        dto.setPrimaryReasonForApplying(this.primaryReasonForApplying);
        dto.setImplementedCsafPractices(this.implementedCsafPractices);
        dto.setFieldName(this.fieldName.stream()
                .map(FieldName::toDto)
                .collect(Collectors.toSet()));
        return dto;
    }
}

