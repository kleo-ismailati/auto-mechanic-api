package com.codemonkeys.car_mechanic.api.mapper;

import com.codemonkeys.car_mechanic.api.dto.client.ClientDto;
import com.codemonkeys.car_mechanic.api.dto.client.client_edit.ClientEditDto;
import com.codemonkeys.car_mechanic.api.dto.client.client_list.ClientListItemDto;
import com.codemonkeys.car_mechanic.api.dto.client.client_list.ClientPageDto;
import com.codemonkeys.car_mechanic.api.dto.client.new_client.NewClientDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_guest.ClientGuestViewDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_list.ClientRBListItemDto;
import com.codemonkeys.car_mechanic.api.dto.repair_booking.ClientRBDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.codemonkeys.car_mechanic.api.dto.car.new_car.NewCarDto;
import com.codemonkeys.car_mechanic.api.model.Client;

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
		
		clientEntity.setFirstName(clientDto.getFirstName().trim());
		clientEntity.setLastName(clientDto.getLastName().trim());
		clientEntity.setEmail(clientDto.getEmail().trim());
		clientEntity.setPhoneNumber(clientDto.getPhoneNumber().trim());
		clientEntity.setAddress(clientDto.getAddress().trim());
		
		return clientEntity;
		
	}
	public ClientRBDto toViewDto(Client client) {
		
		ClientRBDto clientRBDto = new ClientRBDto();

		clientRBDto.setFirstName(client.getFirstName());
		clientRBDto.setLastName(client.getLastName());
		
		return clientRBDto;
	}

	public ClientRBListItemDto toRBListItemDto(Client client) {

		ClientRBListItemDto clientRBListItemDto = new ClientRBListItemDto();

		clientRBListItemDto.setFirstName(client.getFirstName());
		clientRBListItemDto.setLastName(client.getLastName());

		return clientRBListItemDto;
	}
	
	public Client updateEntity(ClientEditDto clientDto, Client clientEntity) {
		
		
		if(clientDto.getFirstName() != null) {
			clientEntity.setFirstName(clientDto.getFirstName().trim());
		}

		if(clientDto.getLastName() != null) {
			clientEntity.setLastName(clientDto.getLastName().trim());
		}
		
		if(clientDto.getEmail() != null) {
			clientEntity.setEmail(clientDto.getEmail().trim());
		}
		
		if(clientDto.getPhoneNumber() != null) {
			clientEntity.setPhoneNumber(clientDto.getPhoneNumber().trim());
		}
		
		if(clientDto.getAddress() != null) {
			clientEntity.setAddress(clientDto.getAddress().trim());
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

		clientDto.setFirstName(client.getFirstName());
		clientDto.setLastName(client.getLastName());
		clientDto.setEmail(client.getEmail());
		clientDto.setPhoneNumber(client.getPhoneNumber());
		clientDto.setAddress(client.getAddress());

		clientDto.setCars(carMapper.toDtoListForClient(client.getCars()));

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
		clientListItemDto.setPhoneNumber(client.getPhoneNumber());
		clientListItemDto.setEmail(client.getEmail());

		return clientListItemDto;
	}
}
