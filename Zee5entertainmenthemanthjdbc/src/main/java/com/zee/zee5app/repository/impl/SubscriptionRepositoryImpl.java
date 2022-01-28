package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.repository.SubscriptionRepository;
//import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository{
	public SubscriptionRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	private static SubscriptionRepository repository;
	
	public static SubscriptionRepository getInstance() {
		if(repository==null) {
			repository=new SubscriptionRepositoryImpl();
			return repository;
		}
		return repository;
	}
	//private Subscriptions[] Subscriptionss = new Subscriptions[10];
	private ArrayList<Subscriptions> set = new ArrayList();
	//private static int count = -1;

	@Override
	public String addSubscription(Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		
		boolean result = this.set.add(Subscriptions);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}
	@Override //assignment 21-01-22
	public String updateSubscription(String id, Subscriptions Subscriptions) {
		// TODO Auto-generated method stub
		for(Subscriptions Subscription2: set) {
			if(Subscription2.getId().equals(id)) {
				boolean result = this.set.remove(Subscription2);
				boolean result2 = this.set.add(Subscriptions);
				return "success";
				
			}
		}
		return "failure";
	}
	@Override
	public Optional<Subscriptions> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Subscriptions Subscriptions2 = null;
		for(Subscriptions Subscriptions: set) {
			if(Subscriptions.getId().equals(id)) {
				Subscriptions2 = Subscriptions;
				break;
			}
		}
		
		return Optional.ofNullable(Optional.of(Subscriptions2)).orElseThrow(()-> new IdNotFoundException("id not found"));
	}
	
	@Override
	public Subscriptions[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		Subscriptions Subscriptions[]=new Subscriptions[set.size()];
		return set.toArray(Subscriptions);
	}
	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Subscriptions> optional = this.getSubscriptionById(id);
		
		if(optional.isPresent()) {
			
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else {
				return "failure";
			}
		}
//		else {
//			throw new IdNotFoundException("id not found exception");
//		}
		return "failure";
	}
	
	public ArrayList<Subscriptions> getAllSubscriptionDetails(){
	  
		//Collections.sort((List<Subscriptions>)set);
	  
		return new ArrayList<Subscriptions>(set);
		//return new ArrayList<Subscriptions>(set.descendingSet());  //descending order
	}
	  //assignment 21-01-22: 
	
}
