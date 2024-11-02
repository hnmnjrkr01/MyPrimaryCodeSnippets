package com.ust.ms.movie.dto;

public class Info {
	private int movieId;
	private String movieName;
	public Info() {
		// TODO Auto-generated constructor stub
	}
	public Info(int movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
}
