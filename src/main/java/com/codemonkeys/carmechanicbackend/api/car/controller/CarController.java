package com.codemonkeys.carmechanicbackend.api.car.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.car.service.CarService;

@RestController
@RequestMapping("/api/car")
public class CarController {

	private CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CarDto> getCar(@PathVariable("id") Long id) {
		return carService.getCar(id);
	}
	
	@PostMapping
	public ResponseEntity<Car> addCar(@RequestBody NewCarDto newCar) {
		return carService.addCar(newCar);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Car> editCar(@PathVariable("id") Long id, 
			@RequestBody CarDto carDto) {
		return carService.editCar(id, carDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Car> deleteCar(@PathVariable("id") Long id) {
		return carService.deleteCar(id);
	}
}
