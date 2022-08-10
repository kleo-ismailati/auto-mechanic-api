package com.codemonkeys.carmechanicbackend.api.car.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.CarEditDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.car.mapper.CarMapper;
import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.car.repository.CarRepository;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.client.repository.ClientRepository;

@Service
public class CarService {
	
	private CarRepository carRepository;
	private ClientRepository clientRepository;
	
	private CarMapper carMapper;

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

	public ResponseEntity<Void> addCar(NewCarDto newCar) {
		
		Client client = clientRepository.findById(newCar.getClientID()).get();
		
		carRepository.save(carMapper.toNewEntity(newCar, client));
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteCar(Long id) {
		
		carRepository.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> editCar(Long id, CarEditDto carDto) {
		
		Car car = carRepository.findById(id).get();
		
		carMapper.updateEntity(carDto, car);
		
		carRepository.save(car);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
