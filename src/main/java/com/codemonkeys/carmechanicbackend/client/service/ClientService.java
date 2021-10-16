package com.codemonkeys.carmechanicbackend.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemonkeys.carmechanicbackend.client.model.Client;
import com.codemonkeys.carmechanicbackend.client.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

}
