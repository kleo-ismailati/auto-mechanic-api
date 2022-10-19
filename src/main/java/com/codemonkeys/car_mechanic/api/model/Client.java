package com.codemonkeys.car_mechanic.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Please enter client name")
	@Size(min = 3, max = 15)
	private String firstName;

	@NotEmpty(message = "Please enter client lastname")
	@Size(min = 3, max = 15)
	private String lastName;

	@Email
	@Column(unique = true)
	private String email;

	@Pattern(regexp="^\\d{10}$",message="Phone number must be 10 numbers long")
	private String phoneNumber;

	@NotEmpty(message = "Please enter client address")
	@Size(min = 3, max = 100)
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
