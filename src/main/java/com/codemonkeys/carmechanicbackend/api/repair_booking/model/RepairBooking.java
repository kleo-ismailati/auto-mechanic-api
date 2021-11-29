package com.codemonkeys.carmechanicbackend.api.repair_booking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.codemonkeys.carmechanicbackend.api.client.model.Client;

import lombok.Data;

@Data
@Entity
public class RepairBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "REPAIR_BOOKING_SEQ")
	@SequenceGenerator(name = "REPAIR_BOOKING_SEQ")
	private Long id;
	private String date;
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Transient
	private String totalPrice;
	
	
	public RepairBooking() {}

	public RepairBooking(Client client, String date, String totalPrice, String status) {
		this.client = client;
		this.date = date;
		this.totalPrice = totalPrice;
		this.status = status;
	}

}
