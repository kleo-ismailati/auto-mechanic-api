package com.auto_mechanic.auto_mechanic_api.v1.repositories;

import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
