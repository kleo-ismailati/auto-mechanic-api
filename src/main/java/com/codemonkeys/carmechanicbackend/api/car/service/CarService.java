package com.codemonkeys.carmechanicbackend.api.car.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.car.mapper.CarMapper;
import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.car.repository.CarRepository;
import com.codemonkeys.carmechanicbackend.api.exception.ResourceNotFoundException;

@Service
public class CarService {
	
	private CarRepository carRepository;
	
	private CarMapper carMapper;

	public CarService(CarRepository carRepository, 
			CarMapper carMapper) {
		this.carRepository = carRepository;
		this.carMapper = carMapper;
	}
	
	public ResponseEntity<CarDto> getCar(Long id) {
		
		Car car = carRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Car with id: " + id + " not found!"));
		
		return ResponseEntity.ok(carMapper.toDto(car));
	}

	public ResponseEntity<Car> addCar(NewCarDto newCar) {
		
		carRepository.save(carMapper.toNewEntity(newCar));
		
		return new ResponseEntity<Car>(HttpStatus.CREATED);
	}

	public ResponseEntity<Car> deleteCar(Long id) {
		
		carRepository.deleteById(id);
		
		return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Car> editCar(Long id, CarDto carDto) {
		
		Car car = carRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Car with id: " + id + " not found!"));
		carMapper.updateEntity(carDto, car);
		carRepository.save(car);
		
		return new ResponseEntity<Car>(HttpStatus.OK);
	}

}
