package com.EmployeeLeaveManagement.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Leave Management System API")
                                .version("1.0")
                                .description("REST APIs for Employee Leave Management")
                                .contact(new Contact()
                                                .name("TANUJ")
                                                .email("sanapalatanuj@gmail.com")
                                )
                );
    }
}