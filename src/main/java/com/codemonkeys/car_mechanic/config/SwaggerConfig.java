package com.codemonkeys.car_mechanic.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.produces(Collections.singleton("application/json"))
				.consumes(Collections.singleton("application/json"))
				.securityContexts(Collections.singletonList(securityContext()))
				.securitySchemes(List.of(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.codemonkeys.car_mechanic")).build()
				.apiInfo(apiInfo());
   }
   
   private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Car Mechanic REST API", 
	      "Car Mechanic Backend Endpoints", 
	      "1.0", 
	      "", 
	      new Contact("Kleo Ismailati", "https://github.com/kleoIS", "kleoisma@gmail.com"),
	      "", "", Collections.emptyList());
	}
   
   private ApiKey apiKey() { 
	    return new ApiKey("JWT", AUTHORIZATION_HEADER , "header"); 
   }

   private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return List.of(new SecurityReference("JWT", authorizationScopes));
	}
}