package com.ust.ms.movie.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ust.ms.movie.dto.Movie;

@RestController 
@RequestMapping("/cato")
public class Catagerycontroller {
	
	@RequestMapping("/list")
	public Movie geetAllData() {
		
		return new Movie(1001,"RRR");
	}

}
