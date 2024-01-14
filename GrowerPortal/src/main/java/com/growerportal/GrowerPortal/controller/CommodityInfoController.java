package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.CommodityInfo;
import com.growerportal.GrowerPortal.service.CommodityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity-info")
public class CommodityInfoController {

    private final CommodityInfoService commodityInfoService;

    @Autowired
    public CommodityInfoController(CommodityInfoService commodityInfoService) {
        this.commodityInfoService = commodityInfoService;
    }

    @GetMapping
    public ResponseEntity<List<CommodityInfo>> getAllCommodityInfo() {
        List<CommodityInfo> commodityInfoList = commodityInfoService.getAllCommodityInfo();
        return new ResponseEntity<>(commodityInfoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommodityInfo> getCommodityInfoById(@PathVariable Long id) {
        CommodityInfo commodityInfo = commodityInfoService.getCommodityInfoById(id);
        if (commodityInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commodityInfo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommodityInfo> createCommodityInfo(@RequestBody CommodityInfo commodityInfo) {
        CommodityInfo createdCommodityInfo = commodityInfoService.createCommodityInfo(commodityInfo);
        return new ResponseEntity<>(createdCommodityInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommodityInfo> updateCommodityInfo(@PathVariable Long id, @RequestBody CommodityInfo commodityInfo) {
        CommodityInfo updatedCommodityInfo = commodityInfoService.updateCommodityInfo(id, commodityInfo);
        if (updatedCommodityInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCommodityInfo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommodityInfo(@PathVariable Long id) {
        commodityInfoService.deleteCommodityInfo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

