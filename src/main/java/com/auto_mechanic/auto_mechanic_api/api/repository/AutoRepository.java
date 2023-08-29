package com.auto_mechanic.auto_mechanic_api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto_mechanic.auto_mechanic_api.api.model.Auto;

public interface AutoRepository extends JpaRepository<Auto, Long>{

}
