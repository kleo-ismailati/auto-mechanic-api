package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.v1.models.Stats;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.BookingRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.ClientRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.RepairRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    private final BookingRepository bookingRepository;

    private final ClientRepository clientRepository;

    private final AutoRepository autoRepository;

    private final RepairRepository repairRepository;

    public StatsServiceImpl(
            BookingRepository bookingRepository,
            ClientRepository clientRepository,
            AutoRepository autoRepository,
            RepairRepository repairRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.autoRepository = autoRepository;
        this.repairRepository = repairRepository;
    }


    public ResponseEntity<Stats> getStatistics() {
        Stats stats = new Stats();

        stats.setTotalBookingsActive(
                this.bookingRepository.countAllByStatusOrStatus(
                        RepairStatusEnum.toBeDone,
                        RepairStatusEnum.inProgress
                )
        );

        stats.setTotalClients(clientRepository.count());

        stats.setTotalAutos(autoRepository.count());

        long totalPrice = repairRepository.sumTotalPrice();

        stats.setTotalIncome(totalPrice);


        return ResponseEntity.ok(stats);
    }
}
