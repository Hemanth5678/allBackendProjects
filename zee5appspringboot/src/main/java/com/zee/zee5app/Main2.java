package com.zee.zee5app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.dto.Webseries;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.WebseriesRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MoviesService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.WebseriesService;

@SpringBootApplication
public class Main2 {

	public static void main(String[] args) {
	ConfigurableApplicationContext applicationContext= SpringApplication.run(Zee5appspringbootApplication.class, args);
	
//	MoviesService moviesService = applicationContext.getBean(MoviesService.class);
//	EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
////	
////	Optional<Movies> optional;
////	FileOutputStream fileOutputStream=null;
////	try {
////		optional = moviesService.getMovieById("mov001");
////		if(optional.isEmpty()) {
////			System.out.println("movie record not found");
////		}
////		else {
////			System.out.println(optional);
////			
////			Movies movie = optional.get();
////			
////			fileOutputStream = new FileOutputStream("C:\\Movies\\dummy\\sample2.mp4");
////			fileOutputStream.write(movie.getTrailer());
////			
////		}
////	} catch (IdNotFoundException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	} catch (FileNotFoundException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}finally {
////		try {
////			fileOutputStream.close();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//	
//	Movies movie = new Movies();
//	movie.setId("mov001");
//	movie.setAgelimit(18);
//	movie.setCast("Allu Arjun");
//	movie.setLanguage("Hindi");
//	movie.setName("Pushpa");
//	movie.setGenre("abc");
//	movie.setReleasedate("2022");
//	
//	FileInputStream fileInputStream = null;
//	FileOutputStream fileOutputStream = null;
//	try {
//		fileInputStream = new FileInputStream("C:\\Movies\\Sample.mp4");
//		File file= new File("‪‪C:\\Movies\\Sample.mp4");
//		long fileSize = file.length();
//		byte[] allBytes = new byte[(int) fileSize];
//		//fileInputStream.read(allBytes);
//		movie.setTrailer("C:\\Movies\\movieStore\\"+file.getName());
//		
//		
//		String result = moviesService.addMovie(movie);
//		
//		if(result.equals("success")) {
//			
//			fileOutputStream = new FileOutputStream("C:\\Movies\\movieStore\\"+file.getName());
//			//byte[] data = new byte[(int) file.length()];
//			
//			fileInputStream.read(allBytes);
//			fileOutputStream.write(allBytes);
//		}
//		
//	} catch (FileNotFoundException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	finally {
//		try {
//			fileInputStream.close();
//			fileOutputStream.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	Episodes episode = new Episodes();
//	episode.setId("epi001");
//	episode.setEpisodeName("Honour");
//	episode.setLength(50);
//	episode.setSeries(null);
//	
//	FileInputStream fileInputStream1 = null;
//	FileOutputStream fileOutputStream1 = null;
//	try {
//		fileInputStream1 = new FileInputStream("C:\\episode\\Sample.mp4");
//		File file1= new File("‪‪C:\\episode\\Sample.mp4");
//		long fileSize1 = file1.length();
//		byte[] allBytes1 = new byte[(int) fileSize1];
//		//fileInputStream.read(allBytes);
//		episode.setTrailer("C:\\episode\\episodestore\\"+file1.getName());
//		
//		
//		String result = episodeService.addEpisode(episode);
//		
//		if(result.equals("success")) {
//			
//			fileOutputStream1 = new FileOutputStream("C:\\episode\\episodestore\\"+file1.getName());
//			//byte[] data = new byte[(int) file.length()];
//			
//			fileInputStream1.read(allBytes1);
//			fileOutputStream1.write(allBytes1);
//		}
//		
//	} catch (FileNotFoundException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	finally {
//		try {
//			fileInputStream1.close();
//			fileOutputStream1.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	
//	Role role = new Role();
//	role.setRoleName(EROLE.ROLE_ADMIN);
//	
//	Role role2 = new Role();
//	role2.setRoleName(EROLE.ROLE_USER);
//	
//	RoleService roleService = applicationContext.getBean(RoleService.class);
//	RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
////	
//	System.out.println(roleService.addRole(role));
//	System.out.println(roleService.addRole(role2));
////	
//	
//	UserRepository repository = applicationContext.getBean(UserRepository.class);
//	Register register;
//	register = new Register("Hemu004","Hemanth","A V","hemu25@gmail.com","iforgotit",null,null);
//	register.setContactnumber(new BigDecimal("9975477765"));
//	Set<Role> roles = new HashSet<>();
//	roles.add(roleRepository.findById(1).get());
//	roles.add(roleRepository.findById(2).get());
//	register.setRoles(roles);
//	
//	UserService service = applicationContext.getBean(UserService.class);
//	try {
//		System.out.println(service.addUser(register));
//	} catch (AlreadyExistsException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	//System.out.println(repository.existsByEmailAndContactnumber("hemu6@gmail.com",new BigDecimal("9975477765")));
	
	
//	MoviesRepository repository1 = applicationContext.getBean(MoviesRepository.class);
//	Movies Movies;
//	Movies = new Movies("Mov0001","Avengers",18,"Chrisevans, Robert downey jr","action","youtube","2011","English");
//	
//	MoviesService service1 = applicationContext.getBean(MoviesService.class);
//	System.out.println(service1.addMovie(Movies));
//	
//	System.out.println(repository1.existsByName("Avengers"));
//	System.out.println(repository1.findByNameAndLanguage("Avengers", "English"));
	
	
	////Webseries and episode////
	
//	WebseriesRepository repository = applicationContext.getBean(WebseriesRepository.class);
//	WebseriesService webService = applicationContext.getBean(WebseriesService.class);
//	EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
//	
//	Webseries series1 = new Webseries("SER001", "Mirzapur", 18, "Vikram", "action", "youtube", "2018", "Hindi", 9, null);
//	System.out.println(webService.addWebseries(series1));
//	
//	Episodes episode = new Episodes("Ep001", "Blablabla", 45, series1);
//	System.out.println(episodeService.addEpisode(episode));
	
	
	////User and subscription
	
//	UserRepository repository = applicationContext.getBean(UserRepository.class);
//	UserService service = applicationContext.getBean(UserService.class);
//	SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
//	
//	Register register12 = new Register("Hemu004","Hemanth","A V","hemu4@gmail.com","iforgotit",null,null,null);
//	try {
//		System.out.println(service.addUser(register12));
//	} catch (AlreadyExistsException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	Subscriptions subscriptions = new Subscriptions("sub004","2022-02-02","2023-02-02",599.0f,"UPI","active","yearly","yes", register12);
//	System.out.println(subscriptionService.addSubscription(subscriptions));
//	
//	applicationContext.close();
	}
}

