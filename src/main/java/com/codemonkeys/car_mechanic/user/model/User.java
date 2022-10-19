package com.codemonkeys.car_mechanic.user.model;

import javax.persistence.*;

import com.codemonkeys.car_mechanic.image.model.Image;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	@Column(unique = true)
	private String email;

	private String password;

	private String role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;
	
	public User() {}

}
