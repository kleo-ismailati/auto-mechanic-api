package com.codemonkeys.car_mechanic.image.repository;

import com.codemonkeys.car_mechanic.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {

}
