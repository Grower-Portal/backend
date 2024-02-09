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
import java.util.stream.Collectors;


@Data
@Entity
@Table(name = "fieldnames")
public class FieldName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldNameId;

    @Column(nullable = false)
    private String fieldName;

    @ManyToOne
    @JoinColumn(name = "producer_info_id", nullable = false)
    @JsonBackReference
    private ProducerInfo producerInfo;

    @OneToMany(mappedBy = "fieldName", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Farm> farm = new HashSet<>();


    @Column(nullable = false)
    private double reportQtyAcres;

    @OneToOne(mappedBy = "fieldName", cascade = CascadeType.ALL)
    @JsonManagedReference
    private CommodityInfo commodityInfo;




    // Getters and Setters

    public AddApplicationDto.FieldNameDto toDto() {
        AddApplicationDto.FieldNameDto dto = new AddApplicationDto.FieldNameDto();
        dto.setFieldNameId(this.fieldNameId);
        dto.setFieldName(this.fieldName);
        dto.setReportQtyAcres(this.reportQtyAcres);
        // Map farms using streams
        dto.setFarm(this.farm.stream()
                .map(Farm::toDto)
                .collect(Collectors.toSet()));

        dto.setCommodityInfo(this.commodityInfo.toDto());
        return dto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldNameId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FieldName fieldName = (FieldName) obj;
        return Objects.equals(fieldNameId, fieldName.fieldNameId);
    }

    public void addFarm(Farm farm) {
        this.farm.add(farm);
        farm.setFieldName(this);
    }
}



