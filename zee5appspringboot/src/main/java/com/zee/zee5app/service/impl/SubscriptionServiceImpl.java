package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.repository.SubscriptionRepository;
//import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	private static SubscriptionService service;
	//private static SubscriptionServiceImpl repository;
	public SubscriptionServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	/*public static SubscriptionService getInstance() throws IOException {
		if(service==null) {
			service=new SubscriptionServiceImpl();
		}
		return service;
	}*/
	@Autowired
	SubscriptionRepository SubscriptionRepository;// = SubscriptionRepositoryImpl.getInstance();
	@Override
	public String addSubscription(Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		Subscriptions Subscriptions2 = SubscriptionRepository.save(Subscriptions);
		if(Subscriptions2 != null)
		{
			return "success";
		}
		return "failure";
	}
	@Override
	public String updateSubscription(String id, Subscriptions Subscriptions) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (!this.SubscriptionRepository.existsById(id)) {
			throw new IdNotFoundException("Invalid Id");
		}

		return (this.SubscriptionRepository.save(Subscriptions) != null) ? "success" : "fail";
	}
	@Override
	public Optional<Subscriptions> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return SubscriptionRepository.findById(id);
	}
	@Override
	public Subscriptions[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		List<Subscriptions> list = SubscriptionRepository.findAll();
		Subscriptions[] array = new Subscriptions[list.size()];
		return list.toArray(array);
	}
	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscriptions>optional = this.getSubscriptionById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			SubscriptionRepository.deleteById(id);
			return "success";
		}
	}
	@Override
	public Optional<List<Subscriptions>> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(SubscriptionRepository.findAll());
	}

	
}
