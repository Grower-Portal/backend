package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "fieldnames")
public class FieldName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldNameId;

    @Column(nullable = false)
    private String fieldName;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerPersonalInfo farmer;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private AddApplication application;

    @OneToMany(mappedBy = "fieldName", cascade = CascadeType.ALL)
    private Set<FieldNameCluMapping> fieldNameCluMappings;

    @Column(nullable = false)
    private double reportQtyAcres;

    @OneToMany(mappedBy = "field")
    private Set<CommodityInfo> commodityInfos;

    @OneToMany(mappedBy = "field")
    private Set<FieldHistory> fieldHistories;

    // Constructors, Getters, and Setters

    public FieldName() {}

    public FieldName(Long fieldNameId, String fieldName, FarmerPersonalInfo farmer, AddApplication application) {
        this.fieldNameId = fieldNameId;
        this.fieldName = fieldName;
        this.farmer = farmer;
        this.application = application;
    }

    // Getters and Setters
}



