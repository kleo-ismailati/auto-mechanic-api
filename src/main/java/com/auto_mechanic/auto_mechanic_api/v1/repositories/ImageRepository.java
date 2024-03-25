package com.auto_mechanic.auto_mechanic_api.v1.repositories;

import com.auto_mechanic.auto_mechanic_api.v1.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {

}
