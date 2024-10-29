package com.example.intershipmanagement.Servise;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    byte[] storeFile(MultipartFile file);
}
