package com.auto_mechanic.auto_mechanic_api.image.repository;

import com.auto_mechanic.auto_mechanic_api.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {

}
