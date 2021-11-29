package com.codemonkeys.carmechanicbackend.api.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.carmechanicbackend.api.client.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
