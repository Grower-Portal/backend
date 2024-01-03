package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_farmer_field_mapping")
public class FarmerFieldMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmerId")
    private FarmerPersonalInfo farmerPersonalInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cluid")
    private FieldCsvHeader fieldCsvHeader;
}
