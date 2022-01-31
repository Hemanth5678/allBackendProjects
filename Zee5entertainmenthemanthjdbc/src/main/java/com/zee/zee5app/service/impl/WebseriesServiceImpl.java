package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.repository.WebseriesRepository;
import com.zee.zee5app.repository.impl.WebseriesRepositoryImpl;
import com.zee.zee5app.service.WebseriesService;
import com.zee.zee5app.service.WebseriesService;

public class WebseriesServiceImpl implements WebseriesService{

	private static WebseriesService service;
	//private static WebserieserviceImpl repository;
	
	public WebseriesServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	public static WebseriesService getInstance() throws IOException {
		if(service==null) {
			service=new WebseriesServiceImpl();
		}
		return service;
	}
	WebseriesRepository WebseriesRepository = WebseriesRepositoryImpl.getInstance();

	
	
	@Override
	public String addWebseries(Webseries Webseries) {
		// TODO Auto-generated method stub
		return WebseriesRepository.addWebseries(Webseries);
	}
	@Override
	public String updateWebseries(String id, Webseries Webseries) {
		// TODO Auto-generated method stub
		return WebseriesRepository.updateWebseries(id,Webseries);
	}
	@Override
	public Optional<Webseries> getWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return WebseriesRepository.getWebseriesById(id);
	}
	@Override
	public Webseries[] getAllWebseries() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return WebseriesRepository.deleteWebseriesById(id);
	}
	@Override
	public List<Webseries> getAllWebseriesDetails() {
		// TODO Auto-generated method stub
		return WebseriesRepository.getAllWebseriesDetails();
	}
}
