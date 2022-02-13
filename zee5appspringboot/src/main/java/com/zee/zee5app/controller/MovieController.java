package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.service.MoviesService;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	MoviesService moviesService;
	
	@PostMapping("/addMovie")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addMovie(@Valid @RequestBody Movies movies) throws AlreadyExistsException {   // ResponseEntity<?> ,,? :- anytype
		
			String result = moviesService.addMovie(movies);
			return ResponseEntity.status(201).body(result);
	}
	
	
	@GetMapping("/getMovie/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getMovie(@PathVariable("id") String id) throws IdNotFoundException{
		
		Optional<Movies> result = moviesService.getMovieById(id);
		return ResponseEntity.status(201).body(result);
	}
	
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>getAllMovies() {
		Optional<List<Movies>> optional = moviesService.getAllMovieDetails();
		return ResponseEntity.status(201).body(optional);
	}
	
}
