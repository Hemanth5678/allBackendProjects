package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.repository.MoviesRepository;
//import com.zee.zee5app.repository.impl.MoviesRepositoryImpl;
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
	@Autowired
	MoviesRepository MoviesRepository;// = MoviesRepositoryImpl.getInstance();

	public MoviesServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addMovie(Movies Movies) {
		// TODO Auto-generated method stub
		Movies Movies2 = MoviesRepository.save(Movies);
		if(Movies2 != null)
		{
			return "success";
		}
		return "failure";
	}

	@Override
	public String updateMovie(String id, Movies Movies) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (!this.MoviesRepository.existsById(id)) {
			throw new IdNotFoundException("Invalid Id");
		}

		return (this.MoviesRepository.save(Movies) != null) ? "success" : "fail";
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return MoviesRepository.findById(id);
	}

	@Override
	public Movies[] getAllMovies() {
		// TODO Auto-generated method stub
		List<Movies> list = MoviesRepository.findAll();
		Movies[] array = new Movies[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub

		Optional<Movies>optional = this.getMovieById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			MoviesRepository.deleteById(id);
			return "success";
		}
	}

	@Override
	public Optional<List<Movies>> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(MoviesRepository.findAll());
	}
	
}
