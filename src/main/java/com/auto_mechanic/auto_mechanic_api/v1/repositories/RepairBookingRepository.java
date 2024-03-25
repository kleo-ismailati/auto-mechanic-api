package com.auto_mechanic.auto_mechanic_api.v1.repositories;

import com.auto_mechanic.auto_mechanic_api.v1.enums.RepairStatusEnum;
import com.auto_mechanic.auto_mechanic_api.v1.models.RepairBooking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepairBookingRepository extends JpaRepository<RepairBooking, Long> {

    Page<RepairBooking> findAll(Pageable pageable);

    Page<RepairBooking> findAllByStatusOrStatus(
            RepairStatusEnum toBeDoneStatus,
            RepairStatusEnum inProgressStatus,
            Pageable pageable
    );

    Optional<RepairBooking> findFirstByRefID(String refID);

    long countAllByStatusOrStatus(RepairStatusEnum toBeDone, RepairStatusEnum inProgress);
}
