package com.ust.ms.movie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.ms.movie.dto.Movie;


@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@RequestMapping("/list")
	public Movie getAllData(){
		return new Movie(1001,4);
		
		
	}
}
