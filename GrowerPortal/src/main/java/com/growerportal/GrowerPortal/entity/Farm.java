package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmId; // Use a different name for the primary key

    @Column(name = "farm_number", nullable = false, unique = true) // Add farmNumber column
    private Long farmNumber;

    @ManyToOne
    @JoinColumn(name = "field_name_id", nullable = false)
    @JsonBackReference
    private FieldName fieldName;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Tract> tracts = new HashSet<>();

    @OneToOne(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private FarmDetails farmDetails;

    // Getters and setters

    @Override
    public int hashCode() {
        return Objects.hash(farmId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Farm farm = (Farm) obj;
        return Objects.equals(farmId, farm.farmId);
    }

    public void addTract(Tract tract) {
        this.tracts.add(tract);
        tract.setFarm(this);
    }



    public AddApplicationDto.FarmDto toDto() {
        AddApplicationDto.FarmDto dto = new AddApplicationDto.FarmDto();
        dto.setFarmId(this.farmId);
        dto.setFarmNumber(this.farmNumber);
        dto.setFarmDetails(this.farmDetails.toDto());

        return dto;
    }
}


