package com.kani.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	JavaTopicsService topicsJavaService;// = new JavaTopicsService();
	
	@RequestMapping("login.spring")
	public String loginValid() {
		return "Welcome to login page.";
	}

	@RequestMapping("/javatopics")
	public List listValid() {
		return topicsJavaService.getJavaData();
	}
		
	
}
