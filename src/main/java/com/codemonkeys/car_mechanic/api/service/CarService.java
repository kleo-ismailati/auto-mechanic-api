package com.codemonkeys.car_mechanic.api.service;

import com.codemonkeys.car_mechanic.api.dto.car.CarDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.car_mechanic.api.dto.car.car_edit.CarEditDto;
import com.codemonkeys.car_mechanic.api.dto.car.new_car.NewCarDto;
import com.codemonkeys.car_mechanic.api.mapper.CarMapper;
import com.codemonkeys.car_mechanic.api.model.Car;
import com.codemonkeys.car_mechanic.api.repository.CarRepository;
import com.codemonkeys.car_mechanic.api.model.Client;
import com.codemonkeys.car_mechanic.api.repository.ClientRepository;

@Service
public class CarService {
	
	private final CarRepository carRepository;
	private final ClientRepository clientRepository;
	
	private final CarMapper carMapper;

	public CarService(CarRepository carRepository, ClientRepository clientRepository,
			CarMapper carMapper) {
		this.carRepository = carRepository;
		this.clientRepository = clientRepository;
		this.carMapper = carMapper;
	}
	
	public ResponseEntity<CarDto> getCar(Long id) {
		
		Car car = carRepository.findById(id).get();
		
		return ResponseEntity.ok(carMapper.toDto(car));
	}

	public ResponseEntity<Void> addCar(Long id, NewCarDto newCar) {
		
		Client client = clientRepository.findById(id).get();
		
		carRepository.save(carMapper.toNewEntity(newCar, client));
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteCar(Long id) {
		
		carRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editCar(Long id, CarEditDto carDto) {
		
		Car car = carRepository.findById(id).get();
		
		carMapper.updateEntity(carDto, car);
		
		carRepository.save(car);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
