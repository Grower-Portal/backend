package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "field_histories")
public class FieldHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "field_name_id")
    private FieldName field;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private AddApplication application;

    private String landUseHistory;
    private String irrigationHistory;
    private String tillageHistory;
    private String csafPracticeHistory;
    private String pastCsafPracticeHistory;

    // Standard constructors, getters, and setters
}

