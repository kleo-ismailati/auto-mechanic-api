package com.codemonkeys.carmechanicbackend.api.car.mapper;

import java.util.ArrayList;
import java.util.List;

import com.codemonkeys.carmechanicbackend.api.car.dto.*;
import org.springframework.stereotype.Service;

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

	public CarRBListItemDto toRBListItemDto(Car car) {
		
		CarRBListItemDto carRBListItemDto = new CarRBListItemDto();

		carRBListItemDto.setCarModel(car.getCarModel());
		carRBListItemDto.setCarType(car.getCarType());
		
		return carRBListItemDto;
	}

	public CarViewDto toViewDto(Car car) {
		
		CarViewDto carViewDto = new CarViewDto();

		carViewDto.setCarModel(car.getCarModel());
		carViewDto.setCarType(car.getCarType());
		
		return carViewDto;
	}

	public Car updateEntity(CarEditDto carDto, Car car) {
		
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

    public CarGuestViewDto toGuestViewDto(Car car) {

		CarGuestViewDto carGuestViewDto = new CarGuestViewDto();

		carGuestViewDto.setCarModel(car.getCarModel());
		carGuestViewDto.setCarType(car.getCarType());

		return carGuestViewDto;
    }

    public CarDto toDto(Car car) {
		CarDto carDto = new CarDto();

		carDto.setYear(car.getYear());
		carDto.setCarDescription(car.getCarDescription());
		carDto.setColor(car.getColor());
		carDto.setCarModel(car.getCarModel());
		carDto.setCarType(car.getCarType());

		return carDto;
    }

	public List<CarDto> toDtoList(List<Car> cars) {
		List<CarDto> carDtoList = new ArrayList<>();

		for(Car car : cars) {
			carDtoList.add(toDto(car));
		}

		return carDtoList;
	}
}
