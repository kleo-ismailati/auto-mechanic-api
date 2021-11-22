package com.codemonkeys.carmechanicbackend.repair_booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codemonkeys.carmechanicbackend.repair_booking.model.RepairBooking;

@Repository
public interface RepairBookingRepository extends MongoRepository<RepairBooking, String> {

}
