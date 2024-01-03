package com.growerportal.GrowerPortal.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_field_csv_location_details")
public class FieldCsvLocationDetails {

    @Id
    private Long cluid;

    private String fsaPhysicalLocation;
    private String polygon;
}
