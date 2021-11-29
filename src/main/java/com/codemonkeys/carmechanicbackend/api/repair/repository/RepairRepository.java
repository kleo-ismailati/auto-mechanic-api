package com.codemonkeys.carmechanicbackend.api.repair.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;

public interface RepairRepository extends JpaRepository<Repair, Long>{

}
