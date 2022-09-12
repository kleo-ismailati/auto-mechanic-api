package com.codemonkeys.carmechanicbackend.api.car.controller;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarEditDto;
import com.codemonkeys.carmechanicbackend.api.car.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/car")
@Tag(name = "Car", description = "Car Controller")
public class CarController {

	private final CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Get Car by id", tags = { "Car" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Car found"),
	  @ApiResponse(responseCode = "404", description = "Car not found") 
	  })
	public ResponseEntity<CarDto> getCar(@PathVariable("id") Long id) {
		return carService.getCar(id);
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update Car by id", tags = { "Car" })
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Car updated successfully"),
	  @ApiResponse(responseCode = "404", description = "Car not found") 
	  })
	public ResponseEntity<Void> editCar(@PathVariable("id") Long id, 
			@RequestBody CarEditDto carDto) {
		return carService.editCar(id, carDto);
	}
	
//	@DeleteMapping(value = "/{id}")
//	@Operation(summary = "Delete Car by id", tags = { "Car" })
//	@ApiResponses(value = {
//	  @ApiResponse(responseCode = "204", description = "Car deleted successfully"),
//	  @ApiResponse(responseCode = "404", description = "Car not found") 
//	  })
//	public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
//		return carService.deleteCar(id);
//	}
}
