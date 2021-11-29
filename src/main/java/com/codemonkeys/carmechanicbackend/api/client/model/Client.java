package com.codemonkeys.carmechanicbackend.api.client.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.codemonkeys.carmechanicbackend.api.car.model.Car;
import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;

import lombok.Data;

@Data
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CLIENT_SEQ")
	@SequenceGenerator(name = "CLIENT_SEQ")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	
	@OneToOne(mappedBy = "client")
	private RepairBooking repairBooking;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;
	
	public Client() {}

	public Client(Long id, String firstName, String lastName, String email, String phoneNumber, String address,
			RepairBooking repairBooking, Car car) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.repairBooking = repairBooking;
		this.car = car;
	}

}
