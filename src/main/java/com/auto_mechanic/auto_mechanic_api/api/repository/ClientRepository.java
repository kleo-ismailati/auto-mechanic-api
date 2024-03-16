package com.auto_mechanic.auto_mechanic_api.api.repository;

import com.auto_mechanic.auto_mechanic_api.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
