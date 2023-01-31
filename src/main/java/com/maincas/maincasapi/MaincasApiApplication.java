package com.maincas.maincasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class MaincasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaincasApiApplication.class, args);
	}

	@Bean
	AuditorAware<String> auditorAware() {
		return new SecurityAuditorAware();
	}

}
