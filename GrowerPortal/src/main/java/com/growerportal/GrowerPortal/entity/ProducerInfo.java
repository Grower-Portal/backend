package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producer_info")
public class ProducerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producerInfoId;

    @OneToOne(mappedBy = "producerInfo")
    @JsonManagedReference
    private AddApplication application;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerPersonalInfo farmer;

    @Column(nullable = false)
    private String producerName;

    @Column(nullable = false)
    private String producerEntityName;

    @Column(nullable = false)
    private String countyOfResidence;

    @Column(nullable = false)
    private String producerAddress;

    @Column(nullable = false)
    private Boolean isUnderservedSmallProducer;

    @Column(nullable = false)
    private Double baselineYield;

    @Column(nullable = false)
    private String primaryReasonForApplying;

    @Column(nullable = false)
    private Boolean implementedCsafPractices;

    // Standard constructors, getters, and setters
}

