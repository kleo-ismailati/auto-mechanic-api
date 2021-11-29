package com.codemonkeys.carmechanicbackend.api.car.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;

import lombok.Data;

@Data
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CAR_SEQ")
	@SequenceGenerator(name = "CAR_SEQ")
	private Long id;
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
	
	@OneToOne(mappedBy = "car")
	private Client client;
	
	@OneToMany(mappedBy = "car", cascade=CascadeType.ALL)
	private List<Repair> repairs;
	
	public Car() {}

	public Car(Long id, String carType, String carModel, String year, String color, String carDescription,
			Client client, List<Repair> repairs) {
		this.id = id;
		this.carType = carType;
		this.carModel = carModel;
		this.year = year;
		this.color = color;
		this.carDescription = carDescription;
		this.client = client;
		this.repairs = repairs;
	}

}
