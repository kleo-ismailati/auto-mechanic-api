package com.codemonkeys.carmechanicbackend.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codemonkeys.carmechanicbackend.client.model.Client;
import com.codemonkeys.carmechanicbackend.client.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	@ResponseBody
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

}
