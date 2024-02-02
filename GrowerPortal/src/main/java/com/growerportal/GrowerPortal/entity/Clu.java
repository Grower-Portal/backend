package com.growerportal.GrowerPortal.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clus")
public class Clu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cluId;

    @Column(name = "clu_number", nullable = false)
    private Long cluNumber;

    @Column
    private double acres;

    @Column
    private String fsaPhysicalLocation;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerPersonalInfo farmer;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private AddApplication application;

    @ManyToOne
    @JoinColumn(name = "tract_id", nullable = false)
    private Tract tract;

    public Clu() {}

    public Clu(Long cluId, double acres, String fsaPhysicalLocation) {
        this.cluId = cluId;
        this.acres = acres;
        this.fsaPhysicalLocation = fsaPhysicalLocation;
    }

    // Getters and setters
}

