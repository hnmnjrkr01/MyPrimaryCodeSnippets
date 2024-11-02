package com.kani.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JavaTopicsService {
	
	
	public List topics=Arrays.asList(new JavaTopics("SpringBoot", "SpringMVC","Spring"),
               new JavaTopics("JPA","Hibernate","JDBC"),
               new JavaTopics("ReactJS","JavaScript","UI-Development"));
	
	List<JavaTopics> myTopics=new  ArrayList<JavaTopics>(topics);

    public List<JavaTopics> getAllMyTopics() {
    	
    	return myTopics;
    }

    ////Bean  DATA  : RDBMS description MYSQL    id: KINI
    public void addTopic(JavaTopics topic) {
    	
    	myTopics.add(topic);
    }

}
