package com.hla.ficheservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.hla.ficheservice")
@SpringBootApplication
public class FicheServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FicheServiceApplication.class, args);
	}
}
