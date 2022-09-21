package com.codemonkeys.carmechanicbackend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.carmechanicbackend.api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
