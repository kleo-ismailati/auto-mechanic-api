package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.NewRepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.edit.RepairBookingEditDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairBookingDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.RepairBookingGuestViewDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.pages.RepairBookingPageDto;
import org.springframework.http.ResponseEntity;

public interface RepairBookingService {
    ResponseEntity<RepairBookingPageDto> getAllRepairBookings(int page, int size);

    ResponseEntity<RepairBookingPageDto> getUnfinishedRepairBookings(int pageOptional, int sizeOptional);

    ResponseEntity<RepairBookingDto> getRepairBooking(Long id);

    ResponseEntity<RepairBookingGuestViewDto> viewRepairBookingAsGuest(String refID);

    ResponseEntity<Void> addRepairBooking(NewRepairBookingDto newRepairBooking);

    ResponseEntity<Void> deleteRepairBooking(Long id);

    ResponseEntity<Void> editRepairBooking(Long id, RepairBookingEditDto repairBookingDto);
}
