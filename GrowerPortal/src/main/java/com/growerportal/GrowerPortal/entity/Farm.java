package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmId; // Use a different name for the primary key

    @Column(name = "farm_number", nullable = false) // Add farmNumber column
    private Long farmNumber;

    @ManyToOne
    @JoinColumn(name = "producer_info_id", nullable = false)
    @JsonBackReference
    private ProducerInfo producerInfo;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<FieldName> fieldName = new ArrayList<>();

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Tract> tracts = new ArrayList<>();

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
        dto.setFieldName(this.fieldName.stream()
                .map(FieldName::toDto)
                .collect(Collectors.toList()));

        if(farmDetails!=null) {
            dto.setFarmDetails(this.farmDetails.toDto());
        }
//        dto.setFarmDetails(this.farmDetails.toDto());

        return dto;
    }


    public void addFieldName(FieldName fieldName) {
        this.fieldName.add(fieldName);
        fieldName.setFarm(this);
    }
}


