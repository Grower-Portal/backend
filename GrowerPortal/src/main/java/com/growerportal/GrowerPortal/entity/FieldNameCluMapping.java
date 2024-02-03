package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "field_name_clu_mapping")
public class FieldNameCluMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "field_name_id_mapping", nullable = false)
    private FieldName fieldNameMapping;

    @ManyToOne
    @JoinColumn(name = "field_name_id", nullable = false)
    private FieldName fieldName;

    @Column(name = "farm_number", nullable = false)
    private Long farmNumber;

    @Column(name = "tract_number", nullable = false)
    private Long tractNumber;

    @Column(name = "clu_number", nullable = false)
    private Long cluNumber;

    // Constructors, getters, and setters
}

