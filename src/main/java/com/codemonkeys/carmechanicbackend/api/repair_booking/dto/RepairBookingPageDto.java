package com.codemonkeys.carmechanicbackend.api.repair_booking.dto;

import java.util.List;

import lombok.Data;

@Data
public class RepairBookingPageDto {

	private List<RepairBookingListItemDto> result;
	private int pageNo;
	private int size;
	private int total;

}
