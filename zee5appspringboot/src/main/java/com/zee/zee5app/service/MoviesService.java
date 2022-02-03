package com.zee.zee5app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;

public interface MoviesService {
	public String addMovie(Movies Movies);
	public String updateMovie(String id, Movies Movies) throws IdNotFoundException;
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException;
	public Movies[] getAllMovies();
	public String deleteMovieById(String id) throws IdNotFoundException;
	public Optional<List<Movies>> getAllMovieDetails();
}
