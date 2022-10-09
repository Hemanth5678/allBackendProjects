package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.service.EpisodeService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/episode")
public class EpisodeController {

	@Autowired
	EpisodeService episodeService;
	
	@PostMapping("/addEpisode")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addEpisode(@Valid @RequestBody Episodes episodes) throws AlreadyExistsException {   // ResponseEntity<?> ,,? :- anytype
		
			String result = episodeService.addEpisode(episodes);
			return ResponseEntity.status(201).body(result);
	}
	
	
	@GetMapping("/getEpisode/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getEpisode(@PathVariable("id") String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException{
		
		Optional<Episodes> result = episodeService.getEpisodeById(id);
		return ResponseEntity.status(201).body(result);
	}
	
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>getAllEpisodes() throws InvalidIdLengthException {
		Optional<List<Episodes>> optional = episodeService.getAllEpisode();
		return ResponseEntity.status(201).body(optional);
	}
}
