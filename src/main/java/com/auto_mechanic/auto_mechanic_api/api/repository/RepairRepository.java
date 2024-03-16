package com.auto_mechanic.auto_mechanic_api.api.repository;


import com.auto_mechanic.auto_mechanic_api.api.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    @Query("SELECT sum(r.repairCost) from Repair r")
    Long sumTotalPrice();

}
