package com.neumeyer.perfectnumber.application.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth", // A logical name for the security scheme
        type = SecuritySchemeType.HTTP, // The security type is HTTP
        scheme = "basic" // The scheme is basic, which corresponds to username/password
)
public class SwaggerConfig {
}
