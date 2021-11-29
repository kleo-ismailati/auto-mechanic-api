package com.codemonkeys.carmechanicbackend.api.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.carmechanicbackend.api.car.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
