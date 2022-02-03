package com.zee.zee5app.repository.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Webseries;

public interface WebseriesRepository {
	
	public String addWebseries(Webseries Webseries);
	public String updateWebseries(String id, Webseries Webseries);
	public Optional<Webseries> getWebseriesById(String id) throws IdNotFoundException;
	public Webseries[] getAllWebseries();
	public List<Webseries> getAllWebseriesDetails();
	public String deleteWebseriesById(String id) throws IdNotFoundException;
}
