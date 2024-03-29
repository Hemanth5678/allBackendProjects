package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.User;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscriptions, String> {
	
	Subscriptions findByRegister(User register);
}
