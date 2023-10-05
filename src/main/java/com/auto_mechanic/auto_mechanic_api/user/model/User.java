package com.auto_mechanic.auto_mechanic_api.user.model;

import javax.persistence.*;

import com.auto_mechanic.auto_mechanic_api.image.model.Image;
import lombok.Data;

import java.util.Set;

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


	@ManyToMany
	@JoinTable(
			name="user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;
	
	public User() {}

}
