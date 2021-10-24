package com.codemonkeys.carmechanicbackend.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.client.dto.ClientDto;
import com.codemonkeys.carmechanicbackend.client.dto.ClientMapper;
import com.codemonkeys.carmechanicbackend.client.dto.NewClientDto;
import com.codemonkeys.carmechanicbackend.client.model.Client;
import com.codemonkeys.carmechanicbackend.client.repository.ClientRepository;



@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientMapper clientMapper;

	public List<ClientDto> getAllClients() {

		List<Client> clients = clientRepository.findAll();
		return clientMapper.toDtoList(clients);
	}
	
	public ClientDto getClient(String id) {
		
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientException(id));
		return clientMapper.toDto(client);
	}

	public void addClient(NewClientDto newClient) {
		
		clientRepository.save(clientMapper.toEntity(newClient));
	}

	public void deleteClient(String id) {
		
		clientRepository.deleteById(id);
	}

	public void editClient(String id, NewClientDto clientDto) {
		
		Client client = clientRepository.findById(id).orElseThrow(() -> new ClientException(id));
		clientMapper.updateEntity(clientDto, client);
		clientRepository.save(client);
	}

}
