package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.CommodityInfo;
import com.growerportal.GrowerPortal.repository.CommodityInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityInfoService {

    private final CommodityInfoRepository commodityInfoRepository;

    @Autowired
    public CommodityInfoService(CommodityInfoRepository commodityInfoRepository) {
        this.commodityInfoRepository = commodityInfoRepository;
    }

    public List<CommodityInfo> getAllCommodityInfo() {
        return commodityInfoRepository.findAll();
    }

    public CommodityInfo getCommodityInfoById(Long id) {
        return commodityInfoRepository.findById(id).orElse(null);
    }

    public CommodityInfo createCommodityInfo(CommodityInfo commodityInfo) {
        return commodityInfoRepository.save(commodityInfo);
    }

    public CommodityInfo updateCommodityInfo(Long id, CommodityInfo commodityInfo) {
        CommodityInfo existingCommodityInfo = getCommodityInfoById(id);
        if (existingCommodityInfo == null) {
            return null; // Handle not found case
        }

        // Update properties of existingCommodityInfo with values from commodityInfo

        return commodityInfoRepository.save(existingCommodityInfo);
    }

    public void deleteCommodityInfo(Long id) {
        commodityInfoRepository.deleteById(id);
    }
}

