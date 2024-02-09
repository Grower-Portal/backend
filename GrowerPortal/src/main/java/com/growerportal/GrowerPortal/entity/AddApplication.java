package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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

    @OneToOne(mappedBy = "addApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private ProducerInfo producerInfo;

    @Column(nullable = false)
    private LocalDate applicationDate;

    @Column(nullable = false)
    private String status;

    // Getters and setters
    public AddApplicationDto toDto() {
        AddApplicationDto dto = new AddApplicationDto();
        dto.setApplicationId(this.applicationId);
        dto.setFarmerId(this.farmer != null ? this.farmer.getFarmer_ID() : null);
        dto.setProducerInfo(this.producerInfo!=null ? this.producerInfo.toDTO() : null);
        dto.setApplicationDate(this.applicationDate);
        dto.setStatus(this.status);
        return dto;
    }
}

