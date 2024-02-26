package com.growerportal.GrowerPortal.dto;

import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {
    private FarmerPersonalInfo farmer;
    private String jwt;
}
