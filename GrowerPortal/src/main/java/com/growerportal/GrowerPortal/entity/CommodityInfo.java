package com.growerportal.GrowerPortal.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "commodity_info")
public class CommodityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commodityInfoId;

    @OneToOne
    @JoinColumn(name = "field_name_id")
    @JsonBackReference
    private FieldName fieldName;


    private Double reportQtyAcres;
    private String commodityCategory;
    private String commodityType;
    private String landUseHistory;
    private String irrigationHistory;
    private String tillageHistory;
    private String csafPracticeHistory;
    private String pastCsafPracticeHistory;


    // ... getters and setters ...
    public AddApplicationDto.CommodityInfoDto toDto() {
        AddApplicationDto.CommodityInfoDto dto = new AddApplicationDto.CommodityInfoDto();
        dto.setCommodityInfoId(this.commodityInfoId);
        dto.setFieldNameId(this.fieldName != null ? this.fieldName.getFieldNameId() : null);
        dto.setReportQtyAcres(this.reportQtyAcres);
        dto.setCommodityCategory(this.commodityCategory);
        dto.setCommodityType(this.commodityType);
        dto.setLandUseHistory(this.landUseHistory);
        dto.setIrrigationHistory(this.irrigationHistory);
        dto.setTillageHistory(this.tillageHistory);
        dto.setCsafPracticeHistory(this.csafPracticeHistory);
        dto.setPastCsafPracticeHistory(this.pastCsafPracticeHistory);

        return dto;
    }
}
