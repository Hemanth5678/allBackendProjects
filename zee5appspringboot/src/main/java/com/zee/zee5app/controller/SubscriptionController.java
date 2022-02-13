package com.zee.zee5app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

	
	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@GetMapping("/getSubscriptions/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getSubscriptions(@PathVariable("id") String id) throws IdNotFoundException{
		
		Optional<Subscriptions> result = subscriptionService.getSubscriptionById(id);
		return ResponseEntity.status(201).body(result);
	}
	
	
	@GetMapping("/getByUserId/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getSubscriptionsByUserId(@PathVariable("id")Long id) throws IdNotFoundException{
		
		User result = userService.getUserById(id);
		
		Subscriptions suby = subscriptionRepository.findByRegister(result);
		return ResponseEntity.status(201).body(suby);
	}	
		
}
