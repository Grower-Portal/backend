package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_user_roles",
            joinColumns = @JoinColumn(name = "farmer_ID"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Roles> roles = new HashSet<>();


}

