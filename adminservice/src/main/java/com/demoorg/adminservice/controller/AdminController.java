package com.demoorg.adminservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	List<String> adminUsers = Stream.of("Admin 1","Admin 2", "Admin 3").collect(Collectors.toList());
	
	@GetMapping("/admin")
	public List<String> getAdminUsers(){
		return adminUsers;
	}
	

}
