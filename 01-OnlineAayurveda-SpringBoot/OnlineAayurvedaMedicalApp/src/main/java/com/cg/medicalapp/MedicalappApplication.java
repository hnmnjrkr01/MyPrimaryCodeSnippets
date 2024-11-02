package com.cg.medicalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MedicalappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalappApplication.class, args);
		System.out.println(" Aayurveda App  Server Start");
	}

}
