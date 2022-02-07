package com.zee.zee5app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.MoviesService;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MoviesService moviesService;
	
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody Movies movies) throws AlreadyExistsException {   // ResponseEntity<?> ,,? :- anytype
		
			String result = moviesService.addMovie(movies);
			return ResponseEntity.status(201).body(result);
	}
}
