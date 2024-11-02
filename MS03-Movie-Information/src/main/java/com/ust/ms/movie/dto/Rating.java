package com.ust.ms.movie.dto;

public class Rating {
	private int movieId;
	private int movieRating;
	public Rating() {
		// TODO Auto-generated constructor stub
	}
	public Rating(int movieId, int movieRating) {
		super();
		this.movieId = movieId;
		this.movieRating = movieRating;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	
	
}
