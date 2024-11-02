package com.demoorg.helpservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelpserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpserviceApplication.class, args);
		System.out.println("Help Service Started..");
	}

}
