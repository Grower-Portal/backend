package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tracts")
public class Tract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tractId;

    @Column(name = "tract_number", nullable = false)
    private Long tractNumber;

    @OneToMany(mappedBy = "tract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Clu> clus;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    @JsonBackReference
    private Farm farm;

    // Getters and setters
// Ensure the clus set is lazily initialized
    public Set<Clu> getClus() {
        if (clus == null) {
            clus = new HashSet<>();
        }
        return clus;
    }

    // Method to add a Clu to the set
    public void addClu(Clu clu) {
        getClus().add(clu);
        clu.setTract(this);
    }

    public AddApplicationDto.TractDto toDto() {
        AddApplicationDto.TractDto dto = new AddApplicationDto.TractDto();
        dto.setTractId(this.tractId);
        dto.setTractNumber(this.tractNumber);
        dto.setFarmId(this.farm != null ? this.farm.getFarmId() : null);
        return dto;
    }
}


