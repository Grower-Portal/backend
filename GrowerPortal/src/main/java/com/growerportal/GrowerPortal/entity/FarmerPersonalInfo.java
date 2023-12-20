package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;

import java.util.Date;


    @Entity
    @Table(name = "tbl_farmer_personal_info")
    public class FarmerPersonalInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long farmer_ID;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        @Temporal(TemporalType.DATE)
        private Date dob;

        @Column(nullable = false)
        private String address;


    }

