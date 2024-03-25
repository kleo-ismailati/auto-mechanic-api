package com.auto_mechanic.auto_mechanic_api.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.OAS_30)
                .produces(Collections.singleton("application/json"))
                .consumes(Collections.singleton("application/json"))
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(List.of(authenticationScheme()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.auto_mechanic.auto_mechanic_api")).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Auto Mechanic REST API",
                "Auto Mechanic Backend Endpoints",
                "1.0",
                "",
                new Contact("Kleo Ismailati", "https://github.com/kleoIS", "kleoisma@gmail.com"),
                "", "", Collections.emptyList());
    }

    private HttpAuthenticationScheme authenticationScheme() {
        return HttpAuthenticationScheme
                .JWT_BEARER_BUILDER
                .name("JWT")
                .build();
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