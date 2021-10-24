package com.codemonkeys.carmechanicbackend.client.service;

public class ClientException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4336556191320903747L;

	ClientException(String id){
		super("Could not find admin with id: " + id);
	}
}
