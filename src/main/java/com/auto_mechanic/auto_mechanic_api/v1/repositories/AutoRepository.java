package com.auto_mechanic.auto_mechanic_api.v1.repositories;

import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Long> {

}
