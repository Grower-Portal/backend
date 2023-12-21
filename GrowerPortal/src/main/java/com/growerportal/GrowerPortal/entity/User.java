package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;
import lombok.Setter;


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    // Constructors, getters, and setters...
    @Setter
    private String password;

}
