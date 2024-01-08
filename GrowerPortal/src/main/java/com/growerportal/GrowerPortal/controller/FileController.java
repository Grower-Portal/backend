package com.growerportal.GrowerPortal.controller;


import com.growerportal.GrowerPortal.entity.FileEntity;
import com.growerportal.GrowerPortal.service.impl.FileStorageServiceImpl;
import com.growerportal.GrowerPortal.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileStorageService fileStorageService;

    @Autowired
    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file) {
        FileEntity fileEntity = fileStorageService.storeFile(file);
        return ResponseEntity.ok(fileEntity);
    }

    // Additional endpoints for downloading, deleting, etc.
}

