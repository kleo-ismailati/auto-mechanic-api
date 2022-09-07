package com.codemonkeys.carmechanicbackend.api.client.mapper;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.car.mapper.CarMapper;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientEditDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.ClientViewDto;
import com.codemonkeys.carmechanicbackend.api.client.dto.NewClientDto;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;

@Service
public class ClientMapper {
	
	private final CarMapper carMapper;
	
	public ClientMapper(CarMapper carMapper) {
		this.carMapper = carMapper;
	}
	
	public Client toNewEntity(NewClientDto clientDto) {
		
		Client clientEntity = new Client();
		
		clientEntity.setFirstName(clientDto.getFirstName());
		clientEntity.setLastName(clientDto.getLastName());
		clientEntity.setEmail(clientDto.getEmail());
		clientEntity.setPhoneNumber(clientDto.getPhoneNumber());
		clientEntity.setAddress(clientDto.getAddress());
		
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
		
		if (client.getCars() != null) {
			clientDto.setCarDtoList(carMapper.toDtoList(client.getCars()));
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
		
		return clientViewDto;
	}
	
	public Client updateEntity(ClientEditDto clientDto, Client clientEntity) {
		
		
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
		
		return clientEntity;
	}
	
	public void addCar(NewCarDto newCarDto, Client client) {
		
		client.addCar(carMapper.toNewEntity(newCarDto, client));

	}
}
