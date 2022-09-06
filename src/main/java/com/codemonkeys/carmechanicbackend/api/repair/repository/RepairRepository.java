package com.codemonkeys.carmechanicbackend.api.repair.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;
import org.springframework.data.jpa.repository.Query;

public interface RepairRepository extends JpaRepository<Repair, Long>{

    @Query("SELECT sum(r.repairCost) from Repair r")
    Long sumTotalPrice();

}
