package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    FileEntity storeFile(MultipartFile file);
}
