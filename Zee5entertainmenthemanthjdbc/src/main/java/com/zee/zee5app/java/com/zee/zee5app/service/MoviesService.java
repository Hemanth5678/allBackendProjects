package com.zee.zee5app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Movies;

public interface MoviesService {
	public String addMovie(Movies Movies);
	public String updateMovie(String id, Movies Movies);
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException;
	public Movies[] getAllMovies();
	public String deleteMovieById(String id) throws IdNotFoundException;
	public HashSet<Movies> getAllMovieDetails();
}
