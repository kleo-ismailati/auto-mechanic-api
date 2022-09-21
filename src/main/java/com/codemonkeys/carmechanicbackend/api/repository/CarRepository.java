package com.codemonkeys.carmechanicbackend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.carmechanicbackend.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
