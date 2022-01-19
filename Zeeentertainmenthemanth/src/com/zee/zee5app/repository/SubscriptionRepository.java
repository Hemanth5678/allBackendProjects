package com.zee.zee5app.repository;
import com.zee.zee5app.dto.Subscriptions;

public class SubscriptionRepository {

		private Subscriptions[] subscriptions = new Subscriptions[10];
		private static int count = -1;
		private SubscriptionRepository() {
			
		}
		
		public Subscriptions[] getUsers(){
			return subscriptions;
		}
		
		public Subscriptions getUserById(String Id) {
			
			for (Subscriptions subscription : subscriptions) {
				if(subscription!=null && subscription.getId().equals(Id)) {
					return subscription;
				}
			}
			return null;
		}
		
		private static int count2=0;
		public String deleteSubscription(String id) {
			
			for (Subscriptions subscription1 : subscriptions) {
				if(subscription1!=null && subscription1.getId().equals(id)) {
					while(count2<count)
					{
						subscriptions[count2]=subscriptions[count2+1];
						count2++;
					}
					subscriptions[count]=null;
					return "Deleted "+subscription1.getId()+" successfully";
				}
				++count2;
				}
			return "not found";
		}// assignment
		
		//assignment
		private static int count1=0;
		public String updateSubscription(String id, Subscriptions subscription) {     
			for (Subscriptions subscription1 : subscriptions) {
				if(subscription1!=null && subscription1.getId().equals(id)) {
					subscriptions[count1]=subscription;
					return "Updated "+subscription1.getId() +" successfully";
				}
				++count1;
				}
			return "couldnt update";
		}
		//assignment//
		
		public String addSubscription(Subscriptions subscription) {
			if(count==subscriptions.length-1) {
				Subscriptions temp[] = new Subscriptions[subscriptions.length*2];
				System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
				subscriptions=temp;
				subscriptions[++count]=subscription;
				return "successssssssss";
			}
			subscriptions[++count]= subscription;
			return "success";
		}
		
		private static SubscriptionRepository SubscriptionRepository;
		public static SubscriptionRepository getInstance() {
			if(SubscriptionRepository==null)
				SubscriptionRepository = new SubscriptionRepository();
			return SubscriptionRepository;
		}
}