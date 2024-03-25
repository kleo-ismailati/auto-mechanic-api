package com.auto_mechanic.auto_mechanic_api.v1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "auto-mechanic")
public class ConfigProperties {

    private String jwtSecret;

    private String jwtExpirationMs;

    private String uploadDir;

}
