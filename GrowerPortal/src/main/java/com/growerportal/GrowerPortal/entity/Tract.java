package com.growerportal.GrowerPortal.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tracts")
public class Tract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tractId;

    @Column(name = "tract_number", nullable = false)
    private Long tractNumber;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerPersonalInfo farmer;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private AddApplication application;

    @OneToMany(mappedBy = "tract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Clu> clus;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    // Getters and setters
}


