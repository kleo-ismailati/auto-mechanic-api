package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.models.Image;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ResponseEntity<Resource> getImage(String id);

    ResponseEntity<Image> setUserImg(Long id, MultipartFile file);

    ResponseEntity<Image> setAutoImg(Long id, MultipartFile file);
}
