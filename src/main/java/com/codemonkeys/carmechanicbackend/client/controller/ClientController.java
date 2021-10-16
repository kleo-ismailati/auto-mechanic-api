package com.codemonkeys.carmechanicbackend.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codemonkeys.carmechanicbackend.client.model.Client;
import com.codemonkeys.carmechanicbackend.client.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

}
