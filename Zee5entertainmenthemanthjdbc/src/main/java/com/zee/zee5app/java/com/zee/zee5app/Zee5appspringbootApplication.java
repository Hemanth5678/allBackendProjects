package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext= SpringApplication.run(Zee5appspringbootApplication.class, args);
	
		//DataSource dataSource = applicationContext.getBean(DataSource.class);
		
		//System.out.println(dataSource!=null);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		
		System.out.println(userRepository);
		
		UserRepository userRepository2 = applicationContext.getBean(UserRepository.class);
		System.out.println(userRepository2);
		
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository.equals(userRepository2));
		
		//DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
		//System.out.println(dataSource!=null);
		
		Register register=null;
		try {
			register = new Register("Hemu0009","Hemanth","A V","hemulol5@gmail.com","iforgotit");
		} catch (InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register.setContactNumber(new BigDecimal("9975477765"));
		
		
		String result = userRepository.addUser(register);
		System.out.println(result);
		applicationContext.close();
	}

}
