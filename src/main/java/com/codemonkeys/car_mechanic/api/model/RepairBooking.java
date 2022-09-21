package com.codemonkeys.car_mechanic.api.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.codemonkeys.car_mechanic.api.model.shared.RepairStatusEnum;
import lombok.Data;

@Data
@Entity
public class RepairBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime date;

	@Enumerated(EnumType.ORDINAL)
	private RepairStatusEnum status;

	private String refID;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToOne
	@JoinColumn(name = "car_id")
	private Car car;
	
	@OneToMany(mappedBy = "repairBooking", cascade=CascadeType.ALL)
	private List<Repair> repairs;
	
	@Transient
	private Long totalPrice;
	
	
	public RepairBooking() {}

}
