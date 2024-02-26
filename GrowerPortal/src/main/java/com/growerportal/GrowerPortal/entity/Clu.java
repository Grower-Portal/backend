package com.growerportal.GrowerPortal.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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
    @JoinColumn(name = "tract_id", nullable = false)
    @JsonBackReference
    private Tract tract;

    public Clu() {}

    public Clu(Long cluId, double acres, String fsaPhysicalLocation) {
        this.cluId = cluId;
        this.acres = acres;
        this.fsaPhysicalLocation = fsaPhysicalLocation;
    }

    // Getters and setters

    public AddApplicationDto.CluDto toDto() {
        AddApplicationDto.CluDto dto = new AddApplicationDto.CluDto();
        dto.setCluId(this.cluId);
        dto.setCluNumber(this.cluNumber);
        dto.setAcres(this.acres);
        dto.setFsaPhysicalLocation(this.fsaPhysicalLocation);
        dto.setTractId(this.tract != null ? this.tract.getTractId() : null);
        return dto;
    }
}

