package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Webseries;

@Repository
public interface WebseriesRepository extends JpaRepository<Webseries, String> {

//	Boolean existsByName(String Name);
//	
//	Optional<Webseries> findByNameAndLanguage(String Name, String language);
}
