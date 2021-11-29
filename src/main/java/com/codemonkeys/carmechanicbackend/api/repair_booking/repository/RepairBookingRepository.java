package com.codemonkeys.carmechanicbackend.api.repair_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;

@Repository
public interface RepairBookingRepository extends JpaRepository<RepairBooking, Long> {

}
