package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, String> {

	Boolean existsByName(String name);
	
	Optional<Movies> findByNameAndLanguage(String name, String language);
//	
//	Optional<Movies> findByName(String name);
//	
//	Optional<Movies> findByNameAndReleasedate(String name, String Releasedate);
//	
//	Optional<Movies> findByCast(String cast);
}
