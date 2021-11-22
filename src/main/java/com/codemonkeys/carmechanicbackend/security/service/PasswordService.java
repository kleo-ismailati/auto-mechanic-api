package com.codemonkeys.carmechanicbackend.security.service;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
	
	public String encryptPassword(String plainPassword) {
		
		int strength = 10;
		
		BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
		
		String encodedPassword = bCryptPasswordEncoder.encode(plainPassword);
		
		return encodedPassword;
	}
	
	public boolean passMatches(String plainPassword, String savedPassword) {
		
		int strength = 10;
		
		BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
		
		String encodedPassword = bCryptPasswordEncoder.encode(plainPassword);
		
		return bCryptPasswordEncoder.matches(encodedPassword, savedPassword);

	}
}
