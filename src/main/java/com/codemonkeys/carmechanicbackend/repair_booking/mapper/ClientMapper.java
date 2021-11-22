package com.codemonkeys.carmechanicbackend.repair_booking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.repair_booking.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.ClientListDto;
import com.codemonkeys.carmechanicbackend.repair_booking.dto.NewClientDto;
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
		
		
		clientEntity.setCar(carMapper.toNewEntity(clientDto.getCar()));
		
		return clientEntity;
		
	}

	public Client toEntity(String id, ClientDto clientDto) {
		
		Client clientEntity = new Client();
		
		clientEntity.setId(id);
		
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
		
		if(clientDto.getCar() != null) {
			clientEntity.setCar(clientDto.getCar());
		}
		
		return clientEntity;
		
	}
	
	public ClientListDto toDto(Client client) {
		
		ClientListDto clientDto = new ClientListDto();
		
		if(client.getFirstName() != null) {
			clientDto.setFirstName(client.getFirstName());
		}
		
		if(client.getLastName() != null) {
			clientDto.setLastName(client.getLastName());
		}
		
		if(client.getCar() != null) {
			clientDto.setCar(client.getCar());
		}
		
		return clientDto;
	}
	
	public List<ClientListDto> toDtoList(List<Client> clients){
		
		List<ClientListDto> clientDtoList = new ArrayList<ClientListDto>();
		
		for(Client client : clients) {
			clientDtoList.add(toDto(client));
		}
		
		return clientDtoList;
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
		
		if(clientDto.getCar() != null) {
			clientEntity.setCar(clientDto.getCar());
		}
		
		return clientEntity;
	}
}
