package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService{
	private static SubscriptionService service;
	//private static SubscriptionServiceImpl repository;
	public SubscriptionServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	public static SubscriptionService getInstance() throws IOException {
		if(service==null) {
			service=new SubscriptionServiceImpl();
		}
		return service;
	}
	SubscriptionRepository SubscriptionRepository = SubscriptionRepositoryImpl.getInstance();
	@Override
	public String addSubscription(Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		return SubscriptionRepository.addSubscription(Subscriptions);
	}

	@Override
	public String updateSubscription(String id, Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		return SubscriptionRepository.updateSubscription(id, Subscriptions);
	}

	@Override
	public Optional<Subscriptions> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return SubscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public Subscriptions[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return SubscriptionRepository.deleteSubscriptionById(id);
	}

	@Override
	public ArrayList<Subscriptions> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		return SubscriptionRepository.getAllSubscriptionDetails();
	}
	
	
}
