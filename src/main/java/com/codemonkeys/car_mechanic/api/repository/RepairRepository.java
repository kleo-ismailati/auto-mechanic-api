package com.codemonkeys.car_mechanic.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codemonkeys.car_mechanic.api.model.Repair;
import org.springframework.data.jpa.repository.Query;

public interface RepairRepository extends JpaRepository<Repair, Long>{

    @Query("SELECT sum(r.repairCost) from Repair r")
    Long sumTotalPrice();

}
