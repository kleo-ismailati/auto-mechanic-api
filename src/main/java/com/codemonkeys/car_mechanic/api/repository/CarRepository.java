package com.codemonkeys.car_mechanic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.car_mechanic.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
