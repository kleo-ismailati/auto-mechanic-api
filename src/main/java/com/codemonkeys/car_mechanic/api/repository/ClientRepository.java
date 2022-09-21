package com.codemonkeys.car_mechanic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.car_mechanic.api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
