package com.growerportal.GrowerPortal.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerSignupDto {
    private String firstName;
    private String lastName;
    private Date dateOfBirth; // Change this to String if you are parsing the date from a String
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String address;
}
