package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clula") // Replace with your actual table name
public class FieldCsvDetails {

    @Id
    @Column(name = "OBJECTID")
    private Long objectId;

    @Column(name = "clu_identifier", length = 36)
    private String cluIdentifier;

    @Column(name = "clu_number")
    private Long cluNumber;

    @Column(name = "tract_number")
    private Long tractNumber;

    @Column(name = "farm_number")
    private Long farmNumber;

    @Column(name = "clu_classification_code")
    private Long cluClassificationCode;

    @Column(name = "clu_calculated_acreage")
    private Double cluCalculatedAcreage;

    @Column(name = "highly_erodible_land_type_code", length = 4)
    private String highlyErodibleLandTypeCode;

    @Column(name = "comments", length = 25)
    private String comments;

    @Column(name = "state_code")
    private Long stateCode;

    @Column(name = "county_code")
    private Long countyCode;

    @Column(name = "data_source_site_identifier")
    private Double dataSourceSiteIdentifier;

    @Column(name = "creation_date", length = 14)
    private String creationDate;

    @Column(name = "last_change_date", length = 14)
    private String lastChangeDate;

    @Column(name = "data_source", length = 8)
    private String dataSource;

    @Column(name = "admin_state")
    private Long adminState;

    @Column(name = "admin_county")
    private Long adminCounty;

    @Column(name = "cropland_indicator_3CM")
    private Long croplandIndicator3CM;

    @Column(name = "sap_crp")
    private Long sapCrp;

    @Column(name = "clu_status")
    private String cluStatus;

    @Column(name = "cdist_fips")
    private Double cdistFips;

    @Column(name = "edit_reason", length = 35)
    private String editReason;

    @Column(name = "clu_alt_id", length = 38)
    private String cluAltId;

    @Column(name = "last_chg_user_nm", length = 23)
    private String lastChgUserNm;

    @Column(name = "state_ansi_code")
    private Long stateAnsiCode;

    @Column(name = "county_ansi_code")
    private Long countyAnsiCode;

    @Column(name = "Shape_Length")
    private Double shapeLength;

    @Column(name = "Shape_Area")
    private Double shapeArea;

    @Column(name = "fsa_physical_location", length = 21)
    private String fsaPhysicalLocation;

    // Constructors, getters, and setters

    // Define constructors, getters, and setters for all fields
    // ...
}
