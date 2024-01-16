package com.growerportal.GrowerPortal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

    private Long applicationId;
    private FarmerPersonalInfoDto farmer;
    private ProducerInfoDto producerInfo;
    private LocalDate applicationDate;
    private String status;

}
