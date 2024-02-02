package com.growerportal.GrowerPortal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "farm_details")
public class FarmDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmDetailId;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private AddApplication application;

    @ManyToOne
    @JoinColumn(name="farmer_id", nullable = false)
    private FarmerPersonalInfo farmer;

    @OneToOne(mappedBy = "farmDetails")
    @JsonManagedReference
    private Farm farm;

    // Other fields like applicationAcres, totalLandAreaAcres
    @Column(nullable = false)
    private Integer applicationAcres;

    @Column(nullable = false)
    private Integer totalLandAreaAcres;

    @Column(nullable = false)
    private Integer totalCroplandAcres;

    @Column(nullable = false)
    private Integer totalLiveStockAcres;

    @Column(nullable = false)
    private Boolean produceLivestock;

    @Column
    private String livestockType1;

    @Column
    private Integer livestockHead1;

    @Column
    private String livestockType2;

    @Column
    private Integer livestockHead2;

    @Column
    private String livestockType3;

    @Column
    private Integer livestockHead3;

    @Column
    private Integer totalForestAreaAcres;

    @Column
    private String fsaPhysicalLocation;

    @Column
    private String pastCsafPractice;

    @Column
    private String transitioningToUsdaCertified;
    // Constructors, getters, and setters
}
