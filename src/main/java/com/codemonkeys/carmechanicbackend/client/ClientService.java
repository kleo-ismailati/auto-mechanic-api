package com.codemonkeys.carmechanicbackend.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

}
