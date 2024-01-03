package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_field_csv_details")
public class FieldCsvDetails {

    @Id
    private Long cluid;

    private Double totalLandArea;
    private Double totalLivestockArea;
    private String stateCd;
    private String countyCd;
    private String adminCounty;
}
