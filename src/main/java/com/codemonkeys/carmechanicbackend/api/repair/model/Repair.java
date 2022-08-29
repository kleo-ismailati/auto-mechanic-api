package com.codemonkeys.carmechanicbackend.api.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.codemonkeys.carmechanicbackend.api.repair_booking.model.RepairBooking;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Repair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String repairType;
	private String repairDetails;
	private Long repairCost;
	private String repairStatus;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "rb_id", nullable = false)
	private RepairBooking repairBooking;

	public Repair() {
	}

	public Repair(
			Long id, String repairType, String repairDetails, long repairCost, 
			String repairStatus, RepairBooking repairBooking
			) {
		this.id = id;
		this.repairType = repairType;
		this.repairDetails = repairDetails;
		this.repairCost = repairCost;
		this.repairStatus = repairStatus;
		this.repairBooking = repairBooking;
	}

	@Override
	public String toString() {
		return "Repair [id=" + id + ", repairType=" + repairType + ", repairDetails=" + repairDetails + ", repairCost="
				+ repairCost + ", repairStatus=" + repairStatus + "]";
	}

}
