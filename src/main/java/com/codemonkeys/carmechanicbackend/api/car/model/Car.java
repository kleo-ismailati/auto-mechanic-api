package com.codemonkeys.carmechanicbackend.api.car.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.codemonkeys.carmechanicbackend.api.client.model.Client;
import com.codemonkeys.carmechanicbackend.api.repair.model.Repair;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String carType;
	private String carModel;
	private String year;
	private String color;
	private String carDescription;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
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
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carType=" + carType + ", carModel=" + carModel + ", year=" + year + ", color="
				+ color + ", carDescription=" + carDescription + "]";
	}

}
