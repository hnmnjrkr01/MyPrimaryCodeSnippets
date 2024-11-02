package com.demoorg.helpservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelpController {
	
	List<String> helpInfo = Stream.of("Contact US at: ramkumar@gmail.com","Ph1: 2323234333", " Ph2: 342323432").collect(Collectors.toList());
	
	
	@GetMapping("/help")
	public List<String> getHelpInfo(){
		return helpInfo;
	}

}
