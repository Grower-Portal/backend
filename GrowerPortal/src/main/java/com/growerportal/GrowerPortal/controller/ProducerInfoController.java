package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.AddApplicationDto;
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
    public ResponseEntity<List<AddApplicationDto.ProducerInfoDto>> getAllProducerInfo() {
        List<AddApplicationDto.ProducerInfoDto> producerInfoList = producerInfoService.getAllProducerInfo();
        return ResponseEntity.ok(producerInfoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddApplicationDto.ProducerInfoDto> getProducerInfoById(@PathVariable Long id) {
        Optional<AddApplicationDto.ProducerInfoDto> producerInfo = producerInfoService.getProducerInfoById(id);
        return producerInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddApplicationDto.ProducerInfoDto> createProducerInfo(@RequestBody AddApplicationDto.ProducerInfoDto producerInfoDto) {
        AddApplicationDto.ProducerInfoDto createdProducerInfo = producerInfoService.createProducerInfo(producerInfoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducerInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProducerInfo(@PathVariable Long id, @RequestBody AddApplicationDto.ProducerInfoDto producerInfoDto) {
        producerInfoService.updateProducerInfo(id, producerInfoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducerInfo(@PathVariable Long id) {
        producerInfoService.deleteProducerInfo(id);
        return ResponseEntity.noContent().build();
    }
}

