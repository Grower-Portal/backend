package com.growerportal.GrowerPortal.dto;

import com.growerportal.GrowerPortal.entity.FieldName;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class AddApplicationDto {

    private Long applicationId;
    private Long farmerId;
    private ProducerInfoDto producerInfo;
    private LocalDate applicationDate;
    private String status;

    // Getters and setters


    @Data
    @Getter
    @Setter
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
    public static class FieldNameDto {

        private Long fieldNameId;
        private String fieldName;
        private double reportQtyAcres;
        private Set<FarmDto> farm;
        private CommodityInfoDto commodityInfo;

        // Getters and setters
    }

    @Data
    public static class FarmDto {

        private Long farmId;
        private Long farmNumber;
        private List<TractDto> tract;
        private FarmDetailsDto farmDetails;


        // Getters and setters
    }

    @Data
    public static class TractDto {

        private Long tractId;
        private Long tractNumber;
        private Long farmId;
        private List<CluDto> clu;

        // Getters and setters
    }

    @Data
    public static class CluDto {

        private Long cluId;
        private Long cluNumber;
        private double acres;
        private String fsaPhysicalLocation;
        private Long tractId;

        // Getters and setters
    }

    @Data
    public static class FarmDetailsDto {

        private Long farmDetailId;
        private Long FarmId;
        private Integer applicationAcres;
        private Integer totalLandAreaAcres;
        private Integer totalCroplandAcres;
        private Integer totalLiveStockAcres;
        private Boolean produceLivestock;
        private String livestockType1;
        private Integer livestockHead1;
        private String livestockType2;
        private Integer livestockHead2;
        private String livestockType3;
        private Integer livestockHead3;
        private Integer totalForestAreaAcres;
        private String fsaPhysicalLocation;
        private String pastCsafPractice;
        private String transitioningToUsdaCertified;

        // Getters and setters
    }

    @Data
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

