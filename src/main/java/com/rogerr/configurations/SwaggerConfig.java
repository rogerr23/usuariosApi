package com.rogerr.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("API Usuários").version("v1")
				.description("Documentação da API - Projeto Spring Boot com banco de dados PostGreSQL")
				.contact(new Contact().name("Roger Ribeiro Santos").email("roger17ribeiro09@gmail.com")));
	}

}
