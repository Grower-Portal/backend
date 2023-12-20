package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_farmer_request_for_approval")
public class FarmerRequestForApproval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "farmer_ID", nullable = false)
    private FarmerPersonalInfo farmer;

    private String fram;
    private String tract;
    private String clu;
    private String rptQty;
    private String fsaPhysicalLoc;
    private String commodityCty;
    private String commodityType;
    private String growerFieldName;
    private String fieldLandUseHistory;
    private String fieldIrrigationHistory;
    private String livestockTypes;
    private String totalForestArea;
    private String pastCsaPractice;
    private Boolean isTransitioningToOrganic;
    private String documentUpload;
}
