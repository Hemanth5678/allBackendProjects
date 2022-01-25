package com.zee.zee5app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Subscriptions;

public interface SubscriptionRepository {
	
	public String addSubscription(Subscriptions Subscriptions);
	public String updateSubscription(String id, Subscriptions Subscriptions);
	public Optional<Subscriptions> getSubscriptionById(String id) throws IdNotFoundException;
	public Subscriptions[] getAllSubscriptions();
	public ArrayList<Subscriptions> getAllSubscriptionDetails();
	public String deleteSubscriptionById(String id) throws IdNotFoundException;
}
