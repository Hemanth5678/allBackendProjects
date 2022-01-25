package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.repository.SubscriptionRepository;

public class MoviesRepositoryImpl implements MoviesRepository{
	public MoviesRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static MoviesRepository repository;
	
	public static MoviesRepository getInstance() {
		if(repository==null) {
			repository=new MoviesRepositoryImpl();
			return repository;
		}
		return repository;
	}
	
	private HashSet<Movies> set = new HashSet();

	@Override
	public String addMovie(Movies Movies) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(Movies);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateMovie(String id, Movies Movies) {
		// TODO Auto-generated method stub
		
		for(Movies Movies2: set) {
			if(Movies2.getId().equals(id)) {
				boolean result = this.set.remove(Movies2);
				boolean result2 = this.set.add(Movies);
				return "success";
				
			}
		}
		return "failure";
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Movies Movies2 = null;
		for(Movies Movies: set) {
			if(Movies.getId().equals(id)) {
				Movies2 = Movies;
				break;
			}
		}
		
		return Optional.ofNullable(Optional.of(Movies2)).orElseThrow(()-> new IdNotFoundException("id not found"));
	}

	@Override
	public Movies[] getAllMovies() {
		// TODO Auto-generated method stub
		Movies Movies[]=new Movies[set.size()];
		return set.toArray(Movies);
	}

	@Override
	public HashSet<Movies> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return set;
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional = this.getMovieById(id);
		
		if(optional.isPresent()) {
			
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else {
				return "failure";
			}
		}
//		else {
//			throw new IdNotFoundException("id not found exception");
//		}
		return "failure";
	}
	
}
