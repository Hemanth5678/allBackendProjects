package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
//import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscriptions;

public interface SubscriptionService {
	public String addSubscription(Subscriptions Subscriptions);
	public String updateSubscription(String id, Subscriptions Subscriptions) throws IdNotFoundException;
	public Optional<Subscriptions> getSubscriptionById(String id) throws IdNotFoundException;
	public Subscriptions[] getAllSubscriptions();
	public String deleteSubscriptionById(String id) throws IdNotFoundException;
	public Optional<List<Subscriptions>> getAllSubscriptionDetails();
}
