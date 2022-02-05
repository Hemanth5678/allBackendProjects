package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext= SpringApplication.run(Zee5appspringbootApplication.class, args);
	
//		//DataSource dataSource = applicationContext.getBean(DataSource.class);
//		
//		//System.out.println(dataSource!=null);
////		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
////		
////		System.out.println(userRepository);
////		
////		UserRepository userRepository2 = applicationContext.getBean(UserRepository.class);
////		System.out.println(userRepository2);
////		
////		System.out.println(userRepository.hashCode());
////		System.out.println(userRepository.hashCode());
////		System.out.println(userRepository.equals(userRepository2));
//		
//		//DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
//		//System.out.println(dataSource!=null);
//		
//		UserService service = applicationContext.getBean(UserService.class);
//		
//		Register register;
//		register = new Register("Hemu0009","Hemanth","A V","hemu7@gmail.com","iforgotit",null,null);
//		register.setContactnumber(new BigDecimal("9975477765"));
//		try {
//			System.out.println(service.addUser(register));
//		} catch (AlreadyExistsException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		
//		Optional<Register> register1 = null;
//		
//		try {
//			register1 = service.getUserById("Hemu0009");
//			System.out.println(register1);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		Optional<List<Register>>register2;
//		try {
//			register2 = service.getAllUserDetails();
//			register2.get().forEach(e->System.out.println(e));
//		} catch (InvalidIdLengthException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			for(Register register3 : service.getAllUsers()) {
//				System.out.println(register3);
//			}
//		} catch (InvalidIdLengthException | InvalidNameException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			service.deleteUserById("Hemu0001");
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		SubscriptionService service1 = applicationContext.getBean(SubscriptionService.class);
//		
//		Subscriptions subscription;
//		subscription = new Subscriptions("sub0006","2022-02-02","2023-02-02",599.0f,"UPI","active","yearly","yes","Hemu0009");
//		System.out.println(service1.addSubscription(subscription));
//		
//		Optional<Subscriptions> subscription1 = null;
//		
//		try {
//			subscription1 = service1.getSubscriptionById("sub0006");
//			System.out.println(subscription1);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		Optional<List<Subscriptions>>subscription2;
//			subscription2 = service1.getAllSubscriptionDetails();
//			subscription2.get().forEach(e->System.out.println(e));
//		
//			for(Subscriptions subscription3 : service1.getAllSubscriptions()) {
//				System.out.println(subscription3);
//			}
//		
//		
//		try {
//			service1.deleteSubscriptionById("sub0006");
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				applicationContext.close();
	}

}
