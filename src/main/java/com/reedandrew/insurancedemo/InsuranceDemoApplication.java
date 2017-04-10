package com.reedandrew.insurancedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.reedandrew.insurance.repos")
public class InsuranceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceDemoApplication.class, args);
	}
}
