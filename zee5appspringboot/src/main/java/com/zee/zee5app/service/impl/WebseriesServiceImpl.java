package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.repository.WebseriesRepository;
//import com.zee.zee5app.repository.impl.WebseriesRepositoryImpl;
import com.zee.zee5app.service.WebseriesService;
import com.zee.zee5app.service.WebseriesService;

@Service
public class WebseriesServiceImpl implements WebseriesService{

	//private WebseriesService service;
	//private static WebserieserviceImpl repository;
	
	public WebseriesServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	/*public static WebseriesService getInstance() throws IOException {
		if(service==null) {
			service=new WebseriesServiceImpl();
		}
		return service;
	}*/
	@Autowired
	public WebseriesRepository WebseriesRepository;// = WebseriesRepositoryImpl.getInstance();

	
	
	@Override
	public String addWebseries(Webseries Webseries) {
		// TODO Auto-generated method stub
		Webseries Webseries2 = WebseriesRepository.save(Webseries);
		if(Webseries2 != null)
		{
			return "success";
		}
		return "failure";
	}



	@Override
	public String updateWebseries(String id, Webseries Webseries) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (!this.WebseriesRepository.existsById(id)) {
			throw new IdNotFoundException("Invalid Id");
		}

		return (this.WebseriesRepository.save(Webseries) != null) ? "success" : "fail";
	}



	@Override
	public Optional<Webseries> getWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return WebseriesRepository.findById(id);
	}



	@Override
	public Webseries[] getAllWebseries() {
		// TODO Auto-generated method stub
		List<Webseries> list = WebseriesRepository.findAll();
		Webseries[] array = new Webseries[list.size()];
		return list.toArray(array);
	}



	@Override
	public String deleteWebseriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Webseries>optional = this.getWebseriesById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			WebseriesRepository.deleteById(id);
			return "success";
		}
	}



	@Override
	public Optional<List<Webseries>> getAllWebseriesDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(WebseriesRepository.findAll());
	}
	
}
