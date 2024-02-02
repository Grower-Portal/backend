package com.growerportal.GrowerPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerInfoDto {
    private Long producerInfoId;
    private String producerName;
    private String producerEntityName;
    private String countyOfResidence;
    private String producerAddress;
    private boolean isUnderservedSmallProducer;
    private int baselineYield;
    private String primaryReasonForApplying;
    private boolean implementedCsafPractices;
}
