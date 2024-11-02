package com.kani.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControllerHere {

	@RequestMapping("welcome.spring")
	public String welcomValid() {
		return "Welcome to Web";
	}
}
