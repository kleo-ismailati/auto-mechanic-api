package com.codemonkeys.carmechanicbackend.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Admin {
	
	@Id
	private String id;
	private String username;
	private String email;
	private String password;
	
	public Admin() {}

	public Admin(String id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
