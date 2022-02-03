package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.LoginServiceImpl;
import com.zee.zee5app.service.impl.MoviesServiceImpl;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MoviesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.Webseries;

public class Main {

	public static void main(String[] args) throws IdNotFoundException {
		
		/*try {		//change roles
			LoginService service = LoginServiceImpl.getInstance();
			System.out.println(service.changeRole("hemulol@gmail.com", ROLE.ROLE_ADMIN));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		/*UserService service;
		try {			//getalluserdetails
			service = UserServiceImpl.getInstance();
			Optional<List<Register>> optional = service.getAllUserDetails();
			if(optional.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional.get().forEach(e->System.out.println(e));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*MoviesService service; 
		try {			//getall movies details
			service = MoviesServiceImpl.getInstance();
			HashSet<Movies> optional = service.getAllMovieDetails();
			if(optional.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional.forEach(e->System.out.println(e));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		/*MoviesService service;   //get movie by id
		try {			//getall movies details
			service = MoviesServiceImpl.getInstance();
			Optional<Movies> optional = service.getMovieById("mov001");
			if(optional.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				System.out.println(optional);
				//optional.forEach(e->System.out.println(e));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		/*try {   	//adduser
			Register register= new Register("Hemu0007","Hemanth","A V","hemulol3@gmail.com","iforgotit");
			register.setContactNumber(new BigDecimal("9975477764"));
			
			UserService service = UserServiceImpl.getInstance();
			
			String result = service.addUser(register);
			System.out.println(result);
		} catch (InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {   		//add movies
			Movies movies= new Movies("mov001","Titanic","18","Kate,leonardo","romantic","120",null,"12-01-1999","english");
			
			MoviesService service = MoviesServiceImpl.getInstance();
			
			String result = service.addMovie(movies);
			System.out.println(result);
		} catch (InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LocationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try { 		 //deleteuser
			UserService service = UserServiceImpl.getInstance();
			String result = service.deleteUserById("Hemu0005");
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try { 		 //deletemovie
			MoviesService service = MoviesServiceImpl.getInstance();
			String result = service.deleteMovieById("mov001");
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*try {
			LoginService service = LoginServiceImpl.getInstance();
			String result = service.deleteCredentials("Hemu0004");
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {//getuserbyid
			UserService service = UserServiceImpl.getInstance();
			Optional<Register> register =service.getUserById("Hemu00005");
			System.out.println(register.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
}
	/*public static void main(String[] args) throws InvalidNameException {
		// TODO Auto-generated method stub
		
		Register register= new Register();
		Subscriptions subscriptions = new Subscriptions();
		Movies movies = new Movies();
		Webseries webseries = new Webseries();
		//Subscriptions subscription= new Subscriptions();
		// Register: Classname. register : reference to object..store address of object. 
		//new: create object.. Register(): constructor(maybe default constructor).
		
		UserService service = UserServiceImpl.getInstance();
		SubscriptionService service1 = SubscriptionServiceImpl.getInstance();
		MoviesService service2 = MoviesServiceImpl.getInstance();
		
		//for(int i=1;i<=12;i++) {
			//Register register2= new Register();//"hemanth","hemanth","hemanth",null,null);
			try {
				//Register register2= new Register("hemanth","hemanth","hemanth",null,null);
				register.setFirstName("Hemuuuuu");
				register.setLastName("A V shastry");
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			register.setEmail("hemu@gmail.com");
			register.setPassword("iforgotit");
			try {
				register.setId("hemuuuuu"); //+ i
			}catch (InvalidIdLengthException e) {
				e.printStackTrace();
			}
			
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.getEmail());
			
			for(int i=1;i<=20;i++) {
				
				Register register2 = new Register();
				try {
					register2.setId("hemuuuu"+i);
					register2.setFirstName("hemuuuu"+i);
					register2.setLastName("shastry"+i);
				} catch (InvalidIdLengthException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				catch (Throwable e) {
					// TODO: handle exception
				}	
				
				register2.setPassword("iforgotit");
				String result = service.addUser(register2);
				System.out.println(result);
			}
			
		
			for(int i=1;i<=20;i++) {
				
				Register register2 = new Register();
				try {
					register2.setId("hemuuuu"+i);
					register2.setFirstName("hemuuuu"+i);
					register2.setLastName("shastry"+i);
				} catch (InvalidIdLengthException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				catch (Throwable e) {
					// TODO: handle exception
				}	
				
				register2.setPassword("iforgotit");
				String result = service.addUser(register2);
				System.out.println(result);
			}
			
		
			
			
			// userservice object
			// main is consuming the service ?
			
			Optional<Register> optional;
			try {
				optional = service.getUserById("hemuuuu1");
				if(optional.isPresent()) {
					
					System.out.println("getUserById "+optional.get());
				}
				else {
					System.out.println("id not found/available");
				}
				
			
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			service.getAllUserDetails().forEach(e->System.out.println(e));
			
			//update user
			Register register2 = new Register();
			try {
				register2.setId("hemuuuu1");
				register2.setFirstName("hemuuuu241");
				register2.setLastName("shastry2341");
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = service.updateUser("hemuuuu1", register2);	
			System.out.println(result);
			service.getAllUserDetails().forEach(e->System.out.println(e));
			
			
			
			
			try {
				//Register register2= new Register("hemanth","hemanth","hemanth",null,null);
				subscriptions.setAmountpaid("599");
			} catch (InvalidAmountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			subscriptions.setDateofpurchase("21-01-2022");
			subscriptions.setStatus("active");
			subscriptions.setPackcountry("India");
			subscriptions.setPaymentmode("Credit card");
			subscriptions.setAutorenewal("Active");
			subscriptions.setExpirydate("21-01-2023");
			
			try {
				subscriptions.setId("hemuuuuu"); //+ i
			}catch (InvalidIdLengthException e) {
				e.printStackTrace();
			}
			
			System.out.println(subscriptions);
			//System.out.println(subscriptions.toString());
			System.out.println(subscriptions.getId());
			
			
			
			
			try {
				//Register register2= new Register("hemanth","hemanth","hemanth",null,null);
				movies.setLocation("https");
			} catch (LocationNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			movies.setCast("Chris Evans");
			movies.setReleasedate("21-01-2020");
			movies.setTrailer("https");
			movies.setLanguage("English");
			movies.setLength("120 mins");
			
			try {
				movies.setId("hemuuuuu"); //+ i
			}catch (InvalidIdLengthException e) {
				e.printStackTrace();
			}
			
			try {
			movies.setName("Avengers");
			}catch (InvalidNameException e) {
				e.printStackTrace();
			}
			
			System.out.println(movies);
			//System.out.println(subscriptions.toString());
			System.out.println(movies.getId());
			
			
			
			//register2.setFirstName("Hemu");
			//register2.setLastName("A V");
			/*register2.setEmail("hemanth@gmail.com"+i);
			register2.setPassword("iforgotit"+i);
			String result = service.addUser(register2);
			System.out.println(result);
			System.out.println(register2);*/
		//}
		//Register register2 = service.getUserById("hemu3");
		//System.out.println(register2!=null);
		
		/*for (Register register3 : service.getUsers()) {
			if(register3==null) { // if(register3==null) {  System.out.println(register3);}
				break;
			}
			System.out.println(register3);
		}*/
		//assignment
		/*Register register4= new Register();//null, null, null, null, null);
		try {
			//Register register4= new Register("Hemanth", "Hemanth", "Hemanth", null, null);
			register4.setId("hemuuuuu"+5);
			register4.setFirstName("Hemanth");
			register4.setLastName("A Vuuuuu");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//service.getAllUserDetails().forEach(e->System.out.println(e));
		//register4.setFirstName("Hemanth");
		//register4.setLastName("A V");
		/*register4.setEmail("hemanthupdated@gmail.com"+5);
		register4.setPassword("iforgotit"+555);
		String result=service.updateUser(register4.getId(),register4);
		System.out.println(result);*/
		
		//assignment //
		/*String result2=service.deleteUser("hemu2");
		System.out.println(result2);
		for (Register register3 : service.getUsers()) {
			if(register3==null) { // if(register3==null) {  System.out.println(register3);}
				break;
			}
			System.out.println(register3);
		}*/
		//String result = service.addUser(register);
		//System.out.println(result);

		/*
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
		}*/
		//Subscriptions subscription2 = service.getUserById("hemu13");
		//System.out.println(subscription2!=null);
		
		/*for (Register register3 : service.getUsers()) {
			if(register3==null) { // if(register3==null) {  System.out.println(register3);}
				break;
			}
			System.out.println(register3);
		}*/
		//assignment
		/*Subscriptions subscription2= new Subscriptions();
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
		
		/*UserService2 service2 = UserServiceImpl.getInstance();
		for(int i=1;i<=12;i++) {
			Register register5= new Register();
			register5.setId("hemu"+i);
			register5.setFirstName("Hemu");
			register5.setLastName("A V");
			register5.setEmail("hemanth@gmail.com"+i);
			register5.setPassword("iforgotit"+i);
			String result4 = service2.addUser(register5);
			System.out.println(result4);
			System.out.println(register5);
		}*/
		
		/*Optional<Register> optional = service.getUserById("hemuuuuu");
		if(optional.isPresent()) {
			System.out.println("getUserById"+optional.get());
			
		}
		else {
			System.out.println("id not found/available");
		}*/
	//}

//}
//subscription:arraylist,,, invalidamountexception
//movies:hashset
//series:treeset,,, namenotfound,locationnotfound for moviepath