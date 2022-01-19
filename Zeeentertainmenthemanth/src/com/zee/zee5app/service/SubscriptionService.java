package com.zee.zee5app.service;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.dto.Subscriptions;

public class SubscriptionService  {
	private SubscriptionRepository repository =SubscriptionRepository.getInstance();
	private SubscriptionService() {
		
	}
	
	static SubscriptionService service = null;
	public static SubscriptionService getInstance() {
		if(service==null)
				service=new SubscriptionService();
		return service;
	}
	
	public String addSubscription(Subscriptions subscription){
		return this.repository.addSubscription(subscription);
	}
	
	public String updateSubscription(String id,Subscriptions subscription){
		return this.repository.updateSubscription(id,subscription);
	}
	
	public Subscriptions getUserById(String Id) {
		return repository.getUserById(Id);
	}
	
	public Subscriptions[] getUsers(){
		return repository.getUsers();
	}
	
	public String deleteSubscription(String id) {
		return this.repository.deleteSubscription(id);
	}
}
