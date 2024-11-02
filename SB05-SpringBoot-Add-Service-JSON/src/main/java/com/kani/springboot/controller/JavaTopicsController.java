package com.kani.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaTopicsController {
	
	//JavaTopicsService topicsService=new JavaTopicsService();
	// <bean id="topicsService" class="JavaTopicsController"/> 
	@Autowired
	JavaTopicsService topicsService;
	
	//Get
	@RequestMapping("login.spring")
	public String loginValid() {
		return "Welcome to SpringBoot Application";
	}

	   @RequestMapping("/javatopics")
	   public List getAllTopics() {
		   //@ResponseBody
		   return 	topicsService.getAllMyTopics();			                
				   	 
		   		 
	   }
	   
	   //JSON DATA  :   {"name": "RDBMS",  "description": "MYSQL",        "id": "KINI" }
	    @RequestMapping(method=RequestMethod.POST,value="/addtopic")
	   public void addTopic(@RequestBody JavaTopics topic) {
		   
		   topicsService.addTopic(topic);
		   
	   }

}
