package com.auto_mechanic.auto_mechanic_api;

import com.auto_mechanic.auto_mechanic_api.v1.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        ConfigProperties.class
})
public class AutoMechanicApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoMechanicApplication.class, args);
    }

}
