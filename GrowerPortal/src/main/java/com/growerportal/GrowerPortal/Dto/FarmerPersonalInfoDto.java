package com.growerportal.GrowerPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerPersonalInfoDto {
    private Long farmer_ID;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
}
