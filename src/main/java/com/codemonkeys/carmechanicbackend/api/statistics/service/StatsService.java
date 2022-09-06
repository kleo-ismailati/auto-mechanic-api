package com.codemonkeys.carmechanicbackend.api.statistics.service;

import com.codemonkeys.carmechanicbackend.api.car.repository.CarRepository;
import com.codemonkeys.carmechanicbackend.api.client.repository.ClientRepository;
import com.codemonkeys.carmechanicbackend.api.repair.repository.RepairRepository;
import com.codemonkeys.carmechanicbackend.api.repair_booking.repository.RepairBookingRepository;
import com.codemonkeys.carmechanicbackend.api.shared.RepairStatusEnum;
import com.codemonkeys.carmechanicbackend.api.statistics.model.Stats;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final RepairBookingRepository repairBookingRepository;

    private final ClientRepository clientRepository;

    private final CarRepository carRepository;

    private final RepairRepository repairRepository;

    public StatsService(
            RepairBookingRepository repairBookingRepository,
            ClientRepository clientRepository,
            CarRepository carRepository,
            RepairRepository repairRepository
    ) {
        this.repairBookingRepository = repairBookingRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
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

        stats.setTotalCars(carRepository.count());

        Long totalPrice = repairRepository.sumTotalPrice();

        if(totalPrice!=null){
            stats.setTotalIncome(totalPrice);
        }else stats.setTotalIncome(0);


        return ResponseEntity.ok(stats);
    }
}
