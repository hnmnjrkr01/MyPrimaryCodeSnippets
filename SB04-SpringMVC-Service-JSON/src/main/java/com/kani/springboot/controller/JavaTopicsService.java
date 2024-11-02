package com.kani.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class JavaTopicsService {
	
	public List topics = Arrays.asList(new JavaTopics("Java1", "JavaDesc1","javaID1"),
			new JavaTopics("Java2", "JavaDesc2","javaID2"),
			new JavaTopics("Java3", "JavaDesc3","javaID3"));
	
	public List<JavaTopics> getJavaData() {
		return topics;
	}

}
