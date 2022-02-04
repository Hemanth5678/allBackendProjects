package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService{

	@Autowired
	private EpisodeRepository episodeRepository;

	@Override
	public String addEpisode(Episodes episode) {
		// TODO Auto-generated method stub
		Episodes episode2 = episodeRepository.save(episode);
		if (episode2 != null) {
			return "success";
		} else {
			return "failure";
		}
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episodes> optional;
		try {
			optional = this.getEpisodeById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				episodeRepository.deleteById(id);
				return "episode record deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifyEpisode(String id, Episodes episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Episodes> getEpisodeById(String id)
			throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return episodeRepository.findById(id);
	}

	@Override
	public Optional<List<Episodes>> getAllEpisode() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodeRepository.findAll());
	}
	
	
}
