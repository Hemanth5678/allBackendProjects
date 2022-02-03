package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.repository.impl.MoviesRepositoryImpl;
import com.zee.zee5app.service.MoviesService;
//import com.zee.zee5app.service.Movieservice;

@Service
public class MoviesServiceImpl implements MoviesService{
	
	private static MoviesService service;
	//private static MovieserviceImpl repository;
	
	/*public static MoviesService getInstance() throws IOException {
		if(service==null) {
			service=new MoviesServiceImpl();
		}
		return service;
	}*/
	MoviesRepository MoviesRepository;// = MoviesRepositoryImpl.getInstance();

	public MoviesServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addMovie(Movies Movies) {
		// TODO Auto-generated method stub
		return MoviesRepository.addMovie(Movies);
	}
	@Override
	public String updateMovie(String id, Movies Movies) {
		// TODO Auto-generated method stub
		return MoviesRepository.updateMovie(id, Movies);
	}
	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return MoviesRepository.getMovieById(id);
	}
	@Override
	public Movies[] getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return MoviesRepository.deleteMovieById(id);
	}
	@Override
	public HashSet<Movies> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return MoviesRepository.getAllMovieDetails();
	}
}
