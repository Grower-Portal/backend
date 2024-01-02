package com.growerportal.GrowerPortal.entity;

import com.growerportal.GrowerPortal.enums.ERole;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;


}