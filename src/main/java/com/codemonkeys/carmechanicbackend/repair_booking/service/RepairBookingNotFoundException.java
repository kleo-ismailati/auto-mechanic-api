package com.codemonkeys.carmechanicbackend.repair_booking.service;

public class RepairBookingNotFoundException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4336556191320903747L;

	RepairBookingNotFoundException(String id){
		super("Could not find repair booking with id: " + id);
	}
}
