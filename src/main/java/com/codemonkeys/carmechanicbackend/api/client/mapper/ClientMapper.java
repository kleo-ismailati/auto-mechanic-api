package com.codemonkeys.carmechanicbackend.api.client.mapper;

import com.codemonkeys.carmechanicbackend.api.client.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.api.car.dto.NewCarDto;
import com.codemonkeys.carmechanicbackend.api.car.mapper.CarMapper;
import com.codemonkeys.carmechanicbackend.api.client.model.Client;

import java.util.ArrayList;
import java.util.List;

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
	public ClientViewDto toViewDto(Client client) {
		
		ClientViewDto clientViewDto = new ClientViewDto();

		clientViewDto.setFirstName(client.getFirstName());
		clientViewDto.setLastName(client.getLastName());
		
		return clientViewDto;
	}

	public ClientRBListItemDto toRBListItemDto(Client client) {

		ClientRBListItemDto clientRBListItemDto = new ClientRBListItemDto();

		clientRBListItemDto.setFirstName(client.getFirstName());
		clientRBListItemDto.setLastName(client.getLastName());

		return clientRBListItemDto;
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

	public ClientGuestViewDto toGuestViewDto(Client client) {

		ClientGuestViewDto clientGuestViewDto = new ClientGuestViewDto();

		clientGuestViewDto.setFirstName(client.getFirstName());
		clientGuestViewDto.setLastName(client.getLastName());

		return clientGuestViewDto;
	}

	public ClientDto toDto(Client client) {
		ClientDto clientDto = new ClientDto();

		clientDto.setId(client.getId());
		clientDto.setFirstName(client.getFirstName());
		clientDto.setLastName(client.getLastName());
		clientDto.setEmail(client.getEmail());
		clientDto.setPhoneNumber(client.getPhoneNumber());
		clientDto.setAddress(client.getAddress());

		clientDto.setCarDtoList(carMapper.toDtoList(client.getCars()));

		return clientDto;
	}

	public ClientPageDto toClientPage(Page<Client> clients) {
		ClientPageDto clientPageDto = new ClientPageDto();

		List<ClientListItemDto> clientDtoList = new ArrayList<>();

		for (Client client : clients){
			clientDtoList.add(toListItem(client));
		}

		clientPageDto.setResult(clientDtoList);
		clientPageDto.setPageNo(clients.getNumber());
		clientPageDto.setSize(clients.getSize());
		clientPageDto.setTotal(clients.getTotalPages());

		return clientPageDto;
	}

	private ClientListItemDto toListItem(Client client) {
		ClientListItemDto clientListItemDto = new ClientListItemDto();

		clientListItemDto.setId(client.getId());
		clientListItemDto.setFirstName(client.getFirstName());
		clientListItemDto.setLastName(client.getLastName());
		clientListItemDto.setEmail(client.getEmail());

		return clientListItemDto;
	}
}
