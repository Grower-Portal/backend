package com.growerportal.GrowerPortal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddApplicationDto {

    private Long applicationId;
    private Long farmerId;
    private ProducerInfoDto producerInfo;
    private String applicationDate;
    private String status;

    // Getters and setters


    @Data
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProducerInfoDto {
        private Long producerInfoId;
        private Long applicationId;
        private String producerName;
        private String producerEntityName;
        private String countyOfResidence;
        private String producerAddress;
        private String isUnderservedSmallProducer;
        private int baselineYield;
        private String primaryReasonForApplying;
        private String implementedCsafPractices;
        private Set<FieldNameDto> fieldName;

    }

    @Data
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FieldNameDto {

        private Long fieldNameId;
        private String fieldName;
        private double reportQtyAcres;
        private Set<FarmDto> farm;
        private CommodityInfoDto commodityInfo;

        // Getters and setters
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FarmDto {

        private Long farmId;
        private Long farmNumber;
        private List<TractDto> tract;
        private FarmDetailsDto farmDetails;


        // Getters and setters
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TractDto {

        private Long tractId;
        private Long tractNumber;
        private Long farmId;
        private List<CluDto> clu;

        // Getters and setters
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CluDto {

        private Long cluId;
        private Long cluNumber;
        private double acres;
        private String fsaPhysicalLocation;
        private Long tractId;

        // Getters and setters
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FarmDetailsDto {

        private Long farmDetailId;
        private Long FarmId;
        private Double applicationAcres;
        private Double totalLandAreaAcres;
        private Double totalCroplandAcres;
        private Double totalLiveStockAcres;
        private String produceLivestock;
        private String livestockType1;
        private Integer livestockHead1;
        private String livestockType2;
        private Integer livestockHead2;
        private String livestockType3;
        private Integer livestockHead3;
        private Double totalForestAreaAcres;
        private String fsaPhysicalLocation;
        private String pastCsafPractice;
        private String transitioningToUsdaCertified;

        // Getters and setters
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CommodityInfoDto {
        private Long commodityInfoId;
        private Long fieldNameId;
        private Double reportQtyAcres;
        private String commodityCategory;
        private String commodityType;
        private String landUseHistory;
        private String irrigationHistory;
        private String tillageHistory;
        private String csafPracticeHistory;
        private String pastCsafPracticeHistory;
    }
}

