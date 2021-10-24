package com.codemonkeys.carmechanicbackend.client.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.client.model.Client;

@Service
public class ClientMapper {
	
	public Client toEntity(NewClientDto newClient) {
		
		Client clientEntity = new Client();
		
		if(newClient.getFirstName() != null) {
			clientEntity.setFirstName(newClient.getFirstName());
		}
		
		if(newClient.getLastName() != null) {
			clientEntity.setLastName(newClient.getLastName());
		}
		
		if(newClient.getEmail() != null) {
			clientEntity.setEmail(newClient.getEmail());
		}
		
		if(newClient.getPhoneNumber() != null) {
			clientEntity.setPhoneNumber(newClient.getPhoneNumber());
		}
		
		if(newClient.getAddress() != null) {
			clientEntity.setAddress(newClient.getAddress());
		}
		
		if(newClient.getCar() != null) {
			clientEntity.setCar(newClient.getCar());
		}
		
		if(newClient.getCarDescription() != null) {
			clientEntity.setCarDescription(newClient.getCarDescription());
		}
		
		if(newClient.getRepairCost() != null) {
			clientEntity.setRepairCost(newClient.getRepairCost());
		}
		
		if(newClient.getRepairDetails() != null) {
			clientEntity.setRepairDetails(newClient.getRepairDetails());
		}
		
		if(newClient.getRepairStatus() != null) {
			clientEntity.setRepairStatus(newClient.getRepairStatus());
		}
		
		return clientEntity;
		
	}
	
	public Client toEntity(String id, NewClientDto newClient) {
		
		Client clientEntity = new Client();
		
		clientEntity.setId(id);
		
		if(newClient.getFirstName() != null) {
			clientEntity.setFirstName(newClient.getFirstName());
		}
		
		if(newClient.getLastName() != null) {
			clientEntity.setLastName(newClient.getLastName());
		}
		
		if(newClient.getEmail() != null) {
			clientEntity.setEmail(newClient.getEmail());
		}
		
		if(newClient.getPhoneNumber() != null) {
			clientEntity.setPhoneNumber(newClient.getPhoneNumber());
		}
		
		if(newClient.getAddress() != null) {
			clientEntity.setAddress(newClient.getAddress());
		}
		
		if(newClient.getCar() != null) {
			clientEntity.setCar(newClient.getCar());
		}
		
		if(newClient.getCarDescription() != null) {
			clientEntity.setCarDescription(newClient.getCarDescription());
		}
		
		if(newClient.getRepairCost() != null) {
			clientEntity.setRepairCost(newClient.getRepairCost());
		}
		
		if(newClient.getRepairDetails() != null) {
			clientEntity.setRepairDetails(newClient.getRepairDetails());
		}
		
		if(newClient.getRepairStatus() != null) {
			clientEntity.setRepairStatus(newClient.getRepairStatus());
		}
		
		return clientEntity;
		
	}
	
	public ClientDto toDto(Client client) {
		
		ClientDto clientDto = new ClientDto();
		
		if(client.getFirstName() != null) {
			clientDto.setFirstName(client.getFirstName());
		}
		
		if(client.getLastName() != null) {
			clientDto.setLastName(client.getLastName());
		}
		
		if(client.getCar() != null) {
			clientDto.setCar(client.getCar());
		}
		
		if(client.getCarDescription() != null) {
			clientDto.setCarDescription(client.getCarDescription());
		}
		
		if(client.getRepairCost() != null) {
			clientDto.setRepairCost(client.getRepairCost());
		}
		
		if(client.getRepairDetails() != null) {
			clientDto.setRepairDetails(client.getRepairDetails());
		}
		
		if(client.getRepairStatus() != null) {
			clientDto.setRepairStatus(client.getRepairStatus());
		}
		
		return clientDto;
	}
	
	public List<ClientDto> toDtoList(List<Client> clients){
		
		List<ClientDto> clientDtoList = new ArrayList<ClientDto>();
		
		for(Client client : clients) {
			clientDtoList.add(toDto(client));
		}
		
		return clientDtoList;
	}
	
	public Client updateEntity(NewClientDto newClient, Client clientEntity) {
		
		
		if(newClient.getFirstName() != null) {
			clientEntity.setFirstName(newClient.getFirstName());
		}
		
		if(newClient.getLastName() != null) {
			clientEntity.setLastName(newClient.getLastName());
		}
		
		if(newClient.getEmail() != null) {
			clientEntity.setEmail(newClient.getEmail());
		}
		
		if(newClient.getPhoneNumber() != null) {
			clientEntity.setPhoneNumber(newClient.getPhoneNumber());
		}
		
		if(newClient.getAddress() != null) {
			clientEntity.setAddress(newClient.getAddress());
		}
		
		if(newClient.getCar() != null) {
			clientEntity.setCar(newClient.getCar());
		}
		
		if(newClient.getCarDescription() != null) {
			clientEntity.setCarDescription(newClient.getCarDescription());
		}
		
		if(newClient.getRepairCost() != null) {
			clientEntity.setRepairCost(newClient.getRepairCost());
		}
		
		if(newClient.getRepairDetails() != null) {
			clientEntity.setRepairDetails(newClient.getRepairDetails());
		}
		
		if(newClient.getRepairStatus() != null) {
			clientEntity.setRepairStatus(newClient.getRepairStatus());
		}
		
		return clientEntity;
	}
}
