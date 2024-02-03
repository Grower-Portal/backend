package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "applications")
public class AddApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "farmer_id", referencedColumnName = "farmer_ID", nullable = false)
    private FarmerPersonalInfo farmer;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "producer_info_id", referencedColumnName = "producerInfoId")
    private ProducerInfo producerInfo;

    @Column(nullable = false)
    private LocalDate applicationDate;

    @Column(nullable = false)
    private String status;

    // Getters and setters
}

