package com.rogerr;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ProjetoUsuariosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoUsuariosApiApplication.class, args);
	}

}
