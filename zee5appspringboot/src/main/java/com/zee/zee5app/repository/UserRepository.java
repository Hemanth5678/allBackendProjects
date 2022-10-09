package com.zee.zee5app.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//custom jpa method. We wont write any defn, just signature(declaration)
	Boolean existsByEmailAndContactnumber(String email,BigInteger contactnumber);
	//Boolean existsByContactnumber(BigDecimal contactnumber);
	
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
}
