package com.auto_mechanic.auto_mechanic_api.api.dto.repair_booking.repair_booking_list;

import java.util.List;

import lombok.Data;

@Data
public class RepairBookingPageDto {

	private List<RepairBookingListItemDto> result;
	private int pageNo;
	private int size;
	private int total;

}
