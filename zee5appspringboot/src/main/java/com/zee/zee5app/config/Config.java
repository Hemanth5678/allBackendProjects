package com.zee.zee5app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.zee.zee5app.utils.PasswordUtils;

@Configuration		//it is used to mark on config class/+es
//@ComponentScan("com.zee.zee5app")
//@PropertySource("classpath:application.properties")

public class Config {
	
	@Autowired //will bring already created objects based on name
	Environment environment; 

//	@Bean(name = "ds")	//for providing singleton object. Applied on a method/function, not on class
//	@Scope("singleton")		//Scope("prototype"):to get N no of objects when calling bean N times.
//	public DataSource dataSource() {
//		
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		basicDataSource.setDefaultAutoCommit(false);
//		return basicDataSource;
//		
//	}
	
//	@Bean
//	public PasswordUtils passwordUtils() {
//		return new PasswordUtils();
//	}
}
