package com.growerportal.GrowerPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dob;
}
