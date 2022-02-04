package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Episodes;

public interface EpisodeService {

	public String addEpisode(Episodes episode);
	public String deleteEpisode(String id) throws IdNotFoundException;
	public String modifyEpisode(String id, Episodes episode) throws IdNotFoundException;
	public Optional<Episodes> getEpisodeById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	public Optional<List<Episodes>> getAllEpisode() throws InvalidIdLengthException;
}
