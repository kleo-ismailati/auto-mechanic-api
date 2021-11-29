package com.codemonkeys.carmechanicbackend.api.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.codemonkeys.carmechanicbackend.api.car.model.Car;

import lombok.Data;

@Data
@Entity
public class Repair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "REPAIR_SEQ")
	@SequenceGenerator(name = "REPAIR_SEQ")
	private Long id;
	private String repairType;
	private String repairDetails;
	private String repairCost;
	private String repairStatus;
	
	@ManyToOne
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;
	
	public Repair() {
	}

	public Repair(Long id, String repairType, String repairDetails, String repairCost, String repairStatus, Car car) {
		this.id = id;
		this.repairType = repairType;
		this.repairDetails = repairDetails;
		this.repairCost = repairCost;
		this.repairStatus = repairStatus;
		this.car = car;
	}

}
