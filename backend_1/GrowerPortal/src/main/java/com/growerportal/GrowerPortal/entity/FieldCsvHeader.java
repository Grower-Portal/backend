package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_field_csv_header")
public class FieldCsvHeader {

    @Id
    private Long cluid;

    private String fram;
    private String tract;
    private String clu;
}
