package com.codemonkeys.car_mechanic;

import com.codemonkeys.car_mechanic.property.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		ConfigProperties.class
})
public class CarMechanicApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMechanicApplication.class, args);
	}

}
