package com.zee.zee5app;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.dto.Subscriptions;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Register register= new Register();
		
		//Subscriptions subscription= new Subscriptions();
		// Register: Classname. register : reference to object..store address of object. 
		//new: create object.. Register(): constructor(maybe default constructor).
		
		/*register.setFirstName("Hemu");
		register.setLastName("A V");
		register.setEmail("hemanth@gmail.com");
		register.setPassword("password");
		System.out.println(register);
		System.out.println(register.getEmail());*/
		UserService service = UserService.getInstance();
		SubscriptionService service1 = SubscriptionService.getInstance();
		
		for(int i=1;i<=12;i++) {
			Register register2= new Register();
			register2.setId("hemu"+i);
			register2.setFirstName("Hemu");
			register2.setLastName("A V");
			register2.setEmail("hemanth@gmail.com"+i);
			register2.setPassword("iforgotit"+i);
			String result = service.addUser(register2);
			System.out.println(result);
			System.out.println(register2);
		}
		Register register2 = service.getUserById("hemu13");
		System.out.println(register2!=null);
		
		/*for (Register register3 : service.getUsers()) {
			if(register3==null) { // if(register3==null) {  System.out.println(register3);}
				break;
			}
			System.out.println(register3);
		}*/
		//assignment
		Register register4= new Register();
		register4.setId("hemu"+5);
		register4.setFirstName("Hemanth");
		register4.setLastName("A V");
		register4.setEmail("hemanthupdated@gmail.com"+5);
		register4.setPassword("iforgotit"+555);
		String result=service.updateUser(register4.getId(),register4);
		System.out.println(result);
		
		//assignment //
		String result2=service.deleteUser("hemu2");
		System.out.println(result2);
		for (Register register3 : service.getUsers()) {
			if(register3==null) { // if(register3==null) {  System.out.println(register3);}
				break;
			}
			System.out.println(register3);
		}
		//String result = service.addUser(register);
		//System.out.println(result);

		
		
		
		for(int i=1;i<=12;i++) {
			Subscriptions subscription2= new Subscriptions();
			subscription2.setId("Hemu"+i);
			subscription2.setStatus("Active");
			subscription2.setPaymentmode("Credit card");
			subscription2.setPurchasedate("29022022");
			subscription2.setExpirydate("31092022");
			String result1 = service1.addSubscription(subscription2);
			System.out.println(result1);
			System.out.println(subscription2);
		}
		//Subscriptions subscription2 = service.getUserById("hemu13");
		//System.out.println(subscription2!=null);
		
		/*for (Register register3 : service.getUsers()) {
			if(register3==null) { // if(register3==null) {  System.out.println(register3);}
				break;
			}
			System.out.println(register3);
		}*/
		//assignment
		Subscriptions subscription2= new Subscriptions();
		subscription2.setId("Hemu3");
		subscription2.setStatus("Inactive");
		subscription2.setPaymentmode("Credit card");
		subscription2.setPurchasedate("29022022");
		subscription2.setExpirydate("31092022");
		String result1=service1.updateSubscription(subscription2.getId(),subscription2);
		System.out.println(result1);
		
		//assignment //
		String result3=service1.deleteSubscription("Hemu2");
		System.out.println(result3);
		for (Subscriptions subscription3 : service1.getUsers()) {
			if(subscription3==null) { // if(register3==null) {  System.out.println(register3);}
				break;
			}
			System.out.println(subscription3);
		}
		//String result = service.addUser(register);
		//System.out.println(result);
	}

}
