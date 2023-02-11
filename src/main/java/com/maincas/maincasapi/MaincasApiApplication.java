package com.maincas.maincasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MAINCAS API", version = "1.0", description = "Manejo Inteligente a Cadena de Suministro - API de servicios"))
public class MaincasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaincasApiApplication.class, args);
	}
}
