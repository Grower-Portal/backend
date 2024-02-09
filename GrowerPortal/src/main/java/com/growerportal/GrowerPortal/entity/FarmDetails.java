package com.growerportal.GrowerPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "farm_details")
public class FarmDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmDetailId;

    @OneToOne
    @JoinColumn(name = "farm_id", nullable = false)
    @JsonBackReference
    private Farm farm;

    // Other fields like applicationAcres, totalLandAreaAcres
    @Column(nullable = false)
    private Integer applicationAcres;

    @Column(nullable = false)
    private Integer totalLandAreaAcres;

    @Column(nullable = false)
    private Integer totalCroplandAcres;

    @Column(nullable = false)
    private Integer totalLiveStockAcres;

    @Column(nullable = false)
    private Boolean produceLivestock;

    @Column
    private String livestockType1;

    @Column
    private Integer livestockHead1;

    @Column
    private String livestockType2;

    @Column
    private Integer livestockHead2;

    @Column
    private String livestockType3;

    @Column
    private Integer livestockHead3;

    @Column
    private Integer totalForestAreaAcres;

    @Column
    private String fsaPhysicalLocation;

    @Column
    private String pastCsafPractice;

    @Column
    private String transitioningToUsdaCertified;
    // Constructors, getters, and setters



    public AddApplicationDto.FarmDetailsDto toDto() {
        AddApplicationDto.FarmDetailsDto dto = new AddApplicationDto.FarmDetailsDto();
        dto.setFarmDetailId(this.farmDetailId);
        dto.setFarmId(this.farm != null ? this.farm.getFarmId(): null);
        dto.setApplicationAcres(this.applicationAcres);
        dto.setTotalLandAreaAcres(this.totalLandAreaAcres);
        dto.setTotalCroplandAcres(this.totalCroplandAcres);
        dto.setTotalLiveStockAcres(this.totalLiveStockAcres);
        dto.setProduceLivestock(this.produceLivestock);
        dto.setLivestockType1(this.livestockType1);
        dto.setLivestockHead1(this.livestockHead1);
        dto.setLivestockType2(this.livestockType2);
        dto.setLivestockHead2(this.livestockHead2);
        dto.setLivestockType3(this.livestockType3);
        dto.setLivestockHead3(this.livestockHead3);
        dto.setTotalForestAreaAcres(this.totalForestAreaAcres);
        dto.setFsaPhysicalLocation(this.fsaPhysicalLocation);
        dto.setPastCsafPractice(this.pastCsafPractice);
        dto.setTransitioningToUsdaCertified(this.transitioningToUsdaCertified);


        return dto;
    }
}
