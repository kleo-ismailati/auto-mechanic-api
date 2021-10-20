package com.codemonkeys.carmechanicbackend.admin.service;

public class AdminException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4336556191320903747L;

	AdminException(String id){
		super("Could not find admin with id: " + id);
	}

}
