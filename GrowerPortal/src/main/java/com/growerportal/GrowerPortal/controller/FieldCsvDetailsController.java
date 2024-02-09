package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.service.FieldCsvDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/clula")
public class FieldCsvDetailsController {

    @Autowired
    private FieldCsvDetailsService fieldCsvDetailsService;
    @GetMapping("/findFsaPhysicalLocation")
    public String findFsaPhysicalLocation(
            @RequestParam Long farmNumber,
            @RequestParam Long tractNumber,
            @RequestParam Long cluNumber) {
        return fieldCsvDetailsService.findFsaPhysicalLocationByFarmTractClu(farmNumber, tractNumber, cluNumber);
    }

    @GetMapping("/findCluCalculatedAcreage")
    public Double findCluCalculatedAcreage(
            @RequestParam Long farmNumber,
            @RequestParam Long tractNumber,
            @RequestParam Long cluNumber) {
        return fieldCsvDetailsService.findCluCalculatedAcreageByFarmTractClu(farmNumber, tractNumber, cluNumber);
    }

}
