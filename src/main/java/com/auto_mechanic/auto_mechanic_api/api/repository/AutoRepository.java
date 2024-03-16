package com.auto_mechanic.auto_mechanic_api.api.repository;

import com.auto_mechanic.auto_mechanic_api.api.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Long> {

}
