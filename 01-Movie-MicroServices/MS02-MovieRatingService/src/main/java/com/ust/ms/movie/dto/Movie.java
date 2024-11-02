package com.ust.ms.movie.dto;

public class Movie {
	private int movieId;
	private int movieRating;
	public Movie(int movieId, int movieRating) {
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
