package com.codemonkeys.car_mechanic.api.mapper;

import com.codemonkeys.car_mechanic.api.dto.car.CarDto;
import com.codemonkeys.car_mechanic.api.dto.car.car_edit.CarEditDto;
import com.codemonkeys.car_mechanic.api.dto.car.new_car.NewCarDto;
import com.codemonkeys.car_mechanic.api.dto.client.CarClientListItemDto;
import com.codemonkeys.car_mechanic.api.model.Car;
import com.codemonkeys.car_mechanic.api.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarMapper {
	
	
	public CarMapper() {}

	public Car toNewEntity(NewCarDto carDto, Client client) {
		
		Car carEntity = new Car();
		
		carEntity.setCarType(carDto.getCarType().trim());
		carEntity.setCarModel(carDto.getCarModel().trim());
		carEntity.setYear(carDto.getYear().trim());
		carEntity.setColor(carDto.getColor().trim());
		carEntity.setCarDescription(carDto.getCarDescription().trim());
		carEntity.setClient(client);
		
		return carEntity;
	}

	public Car updateEntity(CarEditDto carDto, Car car) {
		
		if(carDto.getCarType() != null) {
			car.setCarType(carDto.getCarType().trim());
		}
		
		if(carDto.getCarModel() != null) {
			car.setCarModel(carDto.getCarModel().trim());
		}
		
		if(carDto.getYear() != null) {
			car.setYear(carDto.getYear().trim());
		}
		
		if(carDto.getColor() != null) {
			car.setColor(carDto.getColor().trim());
		}
		
		if(carDto.getCarDescription() != null) {
			car.setCarDescription(carDto.getCarDescription().trim());
		}
		
		return car;
	}

	public CarDto toDto(Car car) {
		CarDto carDto = new CarDto();

		carDto.setYear(car.getYear());
		carDto.setCarDescription(car.getCarDescription());
		carDto.setColor(car.getColor());
		carDto.setCarModel(car.getCarModel());
		carDto.setCarType(car.getCarType());
		if(car.getImage() != null){
			carDto.setImageId(car.getImage().getId());
		}

		return carDto;
    }

	public CarClientListItemDto toClientListItemDto(Car car) {
		CarClientListItemDto carDto = new CarClientListItemDto();

		carDto.setId(car.getId());
		carDto.setYear(car.getYear());
		carDto.setColor(car.getColor());
		carDto.setCarModel(car.getCarModel());
		carDto.setCarType(car.getCarType());

		return carDto;
	}

	public List<CarClientListItemDto> toDtoListForClient(List<Car> cars) {
		List<CarClientListItemDto> carDtoList = new ArrayList<>();

		for(Car car : cars) {
			carDtoList.add(toClientListItemDto(car));
		}

		return carDtoList;
	}
}
