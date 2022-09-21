package com.codemonkeys.car_mechanic.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	
	@OneToMany(mappedBy = "client", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Car> cars;
	
	public Client() {
		this.cars = new ArrayList<>();
	}
	
	public void addCar(Car car) {
		this.cars.add(car);
	}

}
