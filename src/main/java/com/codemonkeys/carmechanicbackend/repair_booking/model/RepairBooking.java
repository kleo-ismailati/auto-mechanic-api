package com.codemonkeys.carmechanicbackend.repair_booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class RepairBooking {
	
	@Id
	private String id;
	private Client client;
	private String date;
	@Transient
	private String totalPrice;
	private String status;
	
	public RepairBooking() {}

	public RepairBooking(Client client, String date, String totalPrice, String status) {
		this.client = client;
		this.date = date;
		this.totalPrice = totalPrice;
		this.status = status;
	}

}
