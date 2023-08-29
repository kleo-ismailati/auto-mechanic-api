package com.auto_mechanic.auto_mechanic_api.api.service;

import com.auto_mechanic.auto_mechanic_api.api.repository.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.api.repository.ClientRepository;
import com.auto_mechanic.auto_mechanic_api.api.repository.RepairBookingRepository;
import com.auto_mechanic.auto_mechanic_api.api.repository.RepairRepository;
import com.auto_mechanic.auto_mechanic_api.api.model.shared.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.api.model.Stats;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final RepairBookingRepository repairBookingRepository;

    private final ClientRepository clientRepository;

    private final AutoRepository autoRepository;

    private final RepairRepository repairRepository;

    public StatsService(
            RepairBookingRepository repairBookingRepository,
            ClientRepository clientRepository,
            AutoRepository autoRepository,
            RepairRepository repairRepository
    ) {
        this.repairBookingRepository = repairBookingRepository;
        this.clientRepository = clientRepository;
        this.autoRepository = autoRepository;
        this.repairRepository = repairRepository;
    }


    public ResponseEntity<Stats> getStats() {
        Stats stats = new Stats();

        stats.setTotalRepairBookingsActive(
                this.repairBookingRepository.countAllByStatusOrStatus(
                        RepairStatusEnum.toBeDone,
                        RepairStatusEnum.inProgress
                )
        );

        stats.setTotalClients(clientRepository.count());

        stats.setTotalAutos(autoRepository.count());

        Long totalPrice = repairRepository.sumTotalPrice();

        if(totalPrice!=null){
            stats.setTotalIncome(totalPrice);
        }else stats.setTotalIncome(0);


        return ResponseEntity.ok(stats);
    }
}
