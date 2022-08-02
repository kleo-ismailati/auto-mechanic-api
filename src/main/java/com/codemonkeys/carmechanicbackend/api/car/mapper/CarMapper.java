package com.codemonkeys.carmechanicbackend.api.car.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.CarDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.CarViewDto;
import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;

@Service
public class CarMapper {
	
	
	public CarMapper() {}



	public Car toNewEntity(NewCarDto carDto, Client client) {
		
		Car carEntity = new Car();
		
		carEntity.setCarType(carDto.getCarType());
		carEntity.setCarModel(carDto.getCarModel());
		carEntity.setYear(carDto.getYear());
		carEntity.setColor(carDto.getColor());
		carEntity.setCarDescription(carDto.getCarDescription());
		carEntity.setClient(client);
		
		return carEntity;
	}
	
	public Car toEntity(Client client, CarDto carDto) {
		
		Car carEntity = new Car();
		
		if(carDto.getCarType() != null) {
			carEntity.setCarType(carDto.getCarType());
		}
		
		if(carDto.getCarModel() != null) {
			carEntity.setCarModel(carDto.getCarModel());
		}
		
		if(carDto.getYear() != null) {
			carEntity.setYear(carDto.getYear());
		}
		
		if(carDto.getColor() != null) {
			carEntity.setColor(carDto.getColor());
		}
		
		if(carDto.getCarDescription() != null) {
			carEntity.setCarDescription(carDto.getCarDescription());
		}
		
		carEntity.setClient(client);
		
		return carEntity;
	}



	public CarViewDto toViewDto(Car car) {
		
		CarViewDto carViewDto = new CarViewDto();
		
		if(car.getCarModel() != null) {
			carViewDto.setCarModel(car.getCarModel());
		}
		
		if(car.getCarType() != null) {
			carViewDto.setCarType(car.getCarType());
		}
		
		return carViewDto;
	}



	public CarDto toDto(Car car) {
		
		CarDto carDto = new CarDto();
		
		if(car.getId() != null) {
			carDto.setId(car.getId());
		}
		
		if(car.getYear() != null) {
			carDto.setYear(car.getYear());
		}
		
		if(car.getCarDescription() != null) {
			carDto.setCarDescription(car.getCarDescription());
		}
		
		if(car.getColor() != null) {
			carDto.setColor(car.getColor());
		}
		
		if(car.getCarModel() != null) {
			carDto.setCarModel(car.getCarModel());
		}
		
		if(car.getCarType() != null) {
			carDto.setCarType(car.getCarType());
		}
		
		if(car.getClient() != null) {
			carDto.setClientID(car.getClient().getId());
		}
		
		return carDto;
	}



	public Car updateEntity(CarDto carDto, Car car) {
		
		if(carDto.getCarType() != null) {
			car.setCarType(carDto.getCarType());
		}
		
		if(carDto.getCarModel() != null) {
			car.setCarModel(carDto.getCarModel());
		}
		
		if(carDto.getYear() != null) {
			car.setYear(carDto.getYear());
		}
		
		if(carDto.getColor() != null) {
			car.setColor(carDto.getColor());
		}
		
		if(carDto.getCarDescription() != null) {
			car.setCarDescription(carDto.getCarDescription());
		}
		
		return car;
	}



	public List<CarDto> toDtoList(List<Car> cars) {
		
		List<CarDto> carDtoList = new ArrayList<CarDto>();
		
		for(Car car : cars) {
			
			carDtoList.add(toDto(car));
		}
		return carDtoList;
	}

}
