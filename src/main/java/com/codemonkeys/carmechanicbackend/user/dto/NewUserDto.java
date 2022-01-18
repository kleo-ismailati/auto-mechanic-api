package com.codemonkeys.carmechanicbackend.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class NewUserDto {
	
	@NotEmpty(message = "Please enter a user name")
	@Size(min = 3, max = 15)
	private String username;
	
	@Email
	private String email;
	
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$",message="Password must be 8 characters long "
			+ "with atleast one lowcase character and no whitespaces")
	private String password;
	
}
