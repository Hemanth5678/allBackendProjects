package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.repository.WebseriesRepository;
import com.zee.zee5app.repository.WebseriesRepository;

public class WebseriesRepositoryImpl implements WebseriesRepository{

	public WebseriesRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static WebseriesRepository repository;
	
	public static WebseriesRepository getInstance() {
		if(repository==null) {
			repository=new WebseriesRepositoryImpl();
			return repository;
		}
		return repository;
	}
	
	private TreeSet<Webseries> set = new TreeSet<Webseries>();
	
	@Override
	public String addWebseries(Webseries Webseries) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(Webseries);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateWebseries(String id, Webseries Webseries) {
		// TODO Auto-generated method stub
		for(Webseries Webseries2: set) {
			if(Webseries2.getId().equals(id)) {
				boolean result = this.set.remove(Webseries2);
				boolean result2 = this.set.add(Webseries);
				return "success";
				
			}
		}
		return "failure";
	}

	@Override
	public Optional<Webseries> getWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Webseries Webseries2 = null;
		for(Webseries Webseries: set) {
			if(Webseries.getId().equals(id)) {
				Webseries2 = Webseries;
				break;
			}
		}
		
		return Optional.ofNullable(Optional.of(Webseries2)).orElseThrow(()-> new IdNotFoundException("id not found"));
	}

	@Override
	public Webseries[] getAllWebseries() {
		// TODO Auto-generated method stub
		Webseries Webseries[]=new Webseries[set.size()];
		return set.toArray(Webseries);
	}

	@Override
	public List<Webseries> getAllWebseriesDetails() {
		// TODO Auto-generated method stub
		return new ArrayList<Webseries>(set);
	}

	@Override
	public String deleteWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
Optional<Webseries> optional = this.getWebseriesById(id);
		
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
