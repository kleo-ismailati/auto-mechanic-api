package com.codemonkeys.car_mechanic.api.dto.repair_booking.repair_booking_list;

import java.time.LocalDateTime;
import java.util.List;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
import lombok.Data;

@Data
public class RepairBookingListItemDto {
	
	private Long id;
	private LocalDateTime date;
	private RepairStatusEnum status;
	private String firstName;
	private String lastName;
	private String carType;
	private String carModel;
	private List<RepairForRepairBookingListItemDto> repairs;
	private Long totalPrice;
	
}
