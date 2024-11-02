package com.ust.ms.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Ms03MovieInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms03MovieInformationApplication.class, args);
		System.out.println("Moivce Information Service Server Start");
		
			
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
