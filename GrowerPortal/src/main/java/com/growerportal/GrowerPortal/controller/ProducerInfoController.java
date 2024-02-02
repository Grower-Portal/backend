package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.ProducerInfo;
import com.growerportal.GrowerPortal.service.ProducerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producers")
public class ProducerInfoController {

    @Autowired
    private ProducerInfoService producerInfoService;

    @GetMapping
    public ResponseEntity<List<ProducerInfo>> getAllProducerInfo() {
        List<ProducerInfo> producerInfoList = producerInfoService.getAllProducerInfo();
        return ResponseEntity.ok(producerInfoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducerInfo> getProducerInfoById(@PathVariable Long id) {
        Optional<ProducerInfo> producerInfo = producerInfoService.getProducerInfoById(id);
        return producerInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProducerInfo> createProducerInfo(@RequestBody ProducerInfo producerInfo) {
        ProducerInfo createdProducerInfo = producerInfoService.createProducerInfo(producerInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducerInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProducerInfo> updateProducerInfo(@PathVariable Long id, @RequestBody ProducerInfo producerInfo) {
        producerInfoService.updateProducerInfo(id, producerInfo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducerInfo(@PathVariable Long id) {
        producerInfoService.deleteProducerInfo(id);
        return ResponseEntity.noContent().build();
    }
}

