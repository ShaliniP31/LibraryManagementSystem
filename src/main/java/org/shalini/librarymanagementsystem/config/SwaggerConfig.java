package org.shalini.librarymanagementsystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        Info information = new Info()
                .title("RainBear Library API")
                .version("1.0")
                .description("This API exposes endpoints to manage RainBear Library.");
        return new OpenAPI().info(information);
    }
}
