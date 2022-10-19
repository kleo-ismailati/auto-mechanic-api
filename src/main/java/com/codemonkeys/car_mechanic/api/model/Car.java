package com.codemonkeys.car_mechanic.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.codemonkeys.car_mechanic.image.model.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Please enter car type")
	@Size(min = 3, max = 15)
	private String carType;

	@NotEmpty(message = "Please enter car model")
	@Size(min = 3, max = 15)
	private String carModel;

	@Pattern(regexp="^(19|20)\\d{2}$",message="Please enter valid year")
	private String year;

	@NotEmpty(message = "Please enter car color")
	@Size(min = 3, max = 15)
	private String color;
	private String carDescription;

	@Column(unique = true)
	private String licensePlate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	public Car() {}

	public Car(Long id, String carType, String carModel, String year, String color, String carDescription,
			Client client) {
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
