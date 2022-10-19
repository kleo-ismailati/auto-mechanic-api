package com.codemonkeys.car_mechanic.api.repository;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemonkeys.car_mechanic.api.model.RepairBooking;

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