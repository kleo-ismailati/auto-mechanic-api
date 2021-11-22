package com.codemonkeys.carmechanicbackend.repair_booking.mapper;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.car.CarDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.car.CarViewDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.client.ClientDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.client.ClientViewDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.client.NewClientDto;
import com.codemonkeys.carmechanicbackend.repair_booking.model.Car;
import com.codemonkeys.carmechanicbackend.repair_booking.model.Client;

@Service
public class ClientMapper {
	
	private CarMapper carMapper;
	
	public ClientMapper(CarMapper carMapper) {
		this.carMapper = carMapper;
	}
	
	public Client toNewEntity(NewClientDto clientDto) {
		
		Client clientEntity = new Client();
		
		clientEntity.setId(new ObjectId().toString());
		
		clientEntity.setFirstName(clientDto.getFirstName());
		clientEntity.setLastName(clientDto.getLastName());
		clientEntity.setEmail(clientDto.getEmail());
		clientEntity.setPhoneNumber(clientDto.getPhoneNumber());
		clientEntity.setAddress(clientDto.getAddress());
		
		
		clientEntity.setCar(carMapper.toNewEntity(clientDto.getCarDto()));
		
		return clientEntity;
		
	}

	public Client toEntity(ClientDto clientDto) {
		
		Client clientEntity = new Client();
		
		if(clientDto.getId() != null) {
			clientEntity.setId(clientDto.getId());
		}
		
		if(clientDto.getFirstName() != null) {
			clientEntity.setFirstName(clientDto.getFirstName());
		}
		
		if(clientDto.getLastName() != null) {
			clientEntity.setLastName(clientDto.getLastName());
		}
		
		if(clientDto.getEmail() != null) {
			clientEntity.setEmail(clientDto.getEmail());
		}
		
		if(clientDto.getPhoneNumber() != null) {
			clientEntity.setPhoneNumber(clientDto.getPhoneNumber());
		}
		
		if(clientDto.getAddress() != null) {
			clientEntity.setAddress(clientDto.getAddress());
		}
		
		if(clientDto.getCarDto() != null) {
			Car car = carMapper.toEntity(clientDto.getCarDto());
			clientEntity.setCar(car);
		}
		
		return clientEntity;
		
	}
	
	public ClientDto toDto(Client client) {
		
		ClientDto clientDto = new ClientDto();
		
		if(client.getId() != null) {
			clientDto.setId(client.getId());
		}
		
		if(client.getFirstName() != null) {
			clientDto.setFirstName(client.getFirstName());
		}
		
		if(client.getLastName() != null) {
			clientDto.setLastName(client.getLastName());
		}
		
		if(client.getEmail() != null) {
			clientDto.setEmail(client.getEmail());
		}
		
		if(client.getPhoneNumber() != null) {
			clientDto.setPhoneNumber(client.getPhoneNumber());
		}
		
		if(client.getAddress() != null) {
			clientDto.setAddress(client.getAddress());
		}
		
		if(client.getCar() != null) {
			CarDto carDto = carMapper.toDto(client.getCar());
			clientDto.setCarDto(carDto);
		}
		
		return clientDto;
	}
	
	public ClientViewDto toViewDto(Client client) {
		
		ClientViewDto clientViewDto = new ClientViewDto();
		
		if(client.getFirstName() != null) {
			clientViewDto.setFirstName(client.getFirstName());
		}
		
		if(client.getLastName() != null) {
			clientViewDto.setLastName(client.getLastName());
		}
		
		if(client.getCar() != null) {
			CarViewDto carViewDto = carMapper.toViewDto(client.getCar());
			clientViewDto.setCarViewDto(carViewDto);
		}
		
		return clientViewDto;
	}
	
	public Client updateEntity(ClientDto clientDto, Client clientEntity) {
		
		
		if(clientDto.getFirstName() != null) {
			clientEntity.setFirstName(clientDto.getFirstName());
		}
		
		if(clientDto.getLastName() != null) {
			clientEntity.setLastName(clientDto.getLastName());
		}
		
		if(clientDto.getEmail() != null) {
			clientEntity.setEmail(clientDto.getEmail());
		}
		
		if(clientDto.getPhoneNumber() != null) {
			clientEntity.setPhoneNumber(clientDto.getPhoneNumber());
		}
		
		if(clientDto.getAddress() != null) {
			clientEntity.setAddress(clientDto.getAddress());
		}
		
		if(clientDto.getCarDto() != null) {
			Car car = carMapper.updateEntity(clientDto.getCarDto(), clientEntity.getCar());
			clientEntity.setCar(car);
		}
		
		return clientEntity;
	}
}
