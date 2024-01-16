package com.growerportal.GrowerPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerSignupDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private Date dateOfBirth; // Change this to String if you are parsing the date from a String
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private String address;
}
