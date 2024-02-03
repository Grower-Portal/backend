package com.growerportal.GrowerPortal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use a different name for the primary key

    @Column(name = "farm_number", nullable = false, unique = true) // Add farmNumber column
    private Long farmNumber;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private AddApplication application;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerPersonalInfo farmer;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tract> tracts;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore @JsonBackReference
    @JoinColumn(name = "farm_detail_id", referencedColumnName = "farmDetailId")
    private FarmDetails farmDetails;

    // Getters and setters
}


