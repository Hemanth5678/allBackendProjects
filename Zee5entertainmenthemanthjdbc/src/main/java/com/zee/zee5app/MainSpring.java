package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class MainSpring {

	public static void main(String[] args) {
		
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		
		/*DataSource dataSource = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource.hashCode());
		DataSource dataSource2 = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource2.hashCode());
		
		System.out.println(dataSource.equals(dataSource2));*/
		
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		
		System.out.println(userRepository);
		
		UserRepository userRepository2 = applicationContext.getBean(UserRepository.class);
		System.out.println(userRepository2);
		
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository.equals(userRepository2));
		
		DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
		System.out.println(dataSource!=null);
		
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
